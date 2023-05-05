const express = require('express');
const cors = require('cors');
const mongoose = require('mongoose');
const bcrypt = require('bcryptjs');
const salt = bcrypt.genSaltSync(10);
const app = express();
const User = require('./models/User');
const jwt = require('jsonwebtoken');
const cookieParser = require('cookie-parser');

app.use(cors({credentials: true, origin: 'http://localhost:3000'}));
app.use(express.json());


mongoose.connect('mongodb+srv://admin:admin@cluster0.5cvlxzd.mongodb.net/?retryWrites=true&w=majority');

app.post('/register', async (req, res) => {
    const {username, password} = req.body;
    try {
        const userDoc = await User.create({username, password: bcrypt.hashSync(password, salt)});
        res.json(userDoc);
    } catch (err) {
        console.log(err);
        res.status(400).json(err);
    }

});

app.post('/login', async (req,res) => {
    
    const {username,password} = req.body;
    const userDoc = await User.findOne({username});
    
    if (userDoc && bcrypt.compareSync(password, userDoc.password)) {
      
        //N entendi mt bem essa parte di jwt, tokens e cookies
        jwt.sign({username,id:userDoc._id}, 'abada', {}, (err, token) => {
        if (err) throw err;
        res.cookie('token', token).json({
          id:userDoc._id,
          username,
        });
      });
    } else {
      res.status(400).json('wrong credentials');
    }
});
  

app.get('/profile', (req,res) => {
    const {token} = req.cookies;
    jwt.verify(token, secret, {}, (err,info) => {
      if (err) throw err;
      res.json(info);
    });
});

app.post('/logout', (req,res) => {
    res.clearCookie('token').json('logged out');
});

app.listen(4000);