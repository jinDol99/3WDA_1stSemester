const express = require('express');
const { renderLogin, createDomain } = require('../controllers');
const { isLoggedIn } = require('../middlewares');
const { test } = require('../controllers');

const router = express.Router();

//POST /test
router.get('/test', test);

router.get('/', renderLogin);

router.post('/domain', isLoggedIn, createDomain);

module.exports = router;