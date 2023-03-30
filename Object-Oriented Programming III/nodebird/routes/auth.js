const express = require('express');
const passpor = require('passport');

const { isLoggedIn, isNotLoggedIn } = require('../middlewares');
const { join, login, logout } = require('../controllers/auth');
const { route } = require('./page');

const router = express.Router();

// POST /auth/join
router.post('/join', isNotLoggedIn, join);

// POST /auth/login
router.post('/login', isNotLoggedIn, login);

// POST /auth/logout
router.post('/logout', isLoggedIn, login);

module.exports = router;