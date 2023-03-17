const express = require('express');
const morgan = require('morgan');
const dotenv = require('dotenv');
const path = require('path')

const indexRouter = require('./routes');

const app = express();
dotenv.config();
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');

app.use(morgan('dev'));
app.use('/', express.static(path.join(__dirname,'public')));
app.use(express.json());
app.use(express.urlencoded({extended:false}));

app.use('/',indexRouter);

// error 처리
app.use((err, req, res)=>{
    res.send(err);
});

app.listen(3000, ()=>{
    console.log('서버 켜짐');
});