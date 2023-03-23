const express = require('express');
const path = require('path');
const morgan = require('morgan');
const nunjucks = require('nunjucks');
const {sequelize} = require('./models');

const app = express();

app.set('port', process.env.PORT || 3000);
app.set('view engine', 'html');
nunjucks.configure('views', {
    express: app,
    watch: true,
});

// DB 접속 시도하는 코드
sequelize.sync({ force: false })
    .then (() => {
        console.log('데이터베이스 연결 성공');
    })
    .catch((err) => {
        console.error(err);
    });

app.use(morgan('dev'));
app.use(express.static(path.join(__dirname, 'public')));
app.use(express.json());
app.use(express.urlencoded({ extended: false}));

// my routers

// 404 처리
app.use((req, res, next) =>{
    const err = new Error('존재하지 않는 주소입니다.');
    err.status = 404;
    next(err);
    // console.log(app.get('port'), '번 포트에서 대기 중')
})

app.use((err, req, res, next) => {
    const status = err.status || 500;
    res.locals.message = err.message;
    res.locals.error = process.env.NODE_ENV !== 'production' ? err : {};
    res.status(status).render('error');
});

app.listen(app.get('port'), ()=>{
    console.log(app.get('port'), '번 포트에서 대기 중');
});