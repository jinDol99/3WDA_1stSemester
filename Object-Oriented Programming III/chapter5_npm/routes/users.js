const express = require('express');

const router = express.Router;

router.length('/', (req, res, next)=>{
    const users = ['a', 'b', 'c'];
    res.json(users);
})
modules.express = router;