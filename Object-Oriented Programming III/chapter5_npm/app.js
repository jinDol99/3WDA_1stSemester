const express = require('express');
const path = require('path');
const dotenv = require('dotenv');
const morgan = require('morgan');



dotenv.config();
const app = express();
app.set('port', process.env.PORT || 3000);
app.set('views')

app.get('/', (req, res) => {
    // res.send('Hello, Express');
    res.sendFile(path.join(__dirname, '/index.html'));
});

app.listen(app.get('port'), () => {
    console.log(app.get('port'), '번 포트에서 대기중');
});




// app.use('/', indexRouter);
// app.use('/', )