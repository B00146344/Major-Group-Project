const express = require('express');
const bodyParser = require('body-parser');

const app = express();
exports.app = app;
const port = 4000; // Replace with the desired port number
exports.port = port;

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

app.get('/api/Register', (req, res) => {
  // Get the values from query parameters
  const email = req.query.email;
  const pass = req.query.pass;

  console.log(email);
  console.log(pass);

  // Perform database operations if needed

  // Respond with JSON
  res.json({ data: 'valid' });
});

export default function Page() {
    // ... (other code)
  
    const runDBCallAsync = async () => {
      try {
        const url = `http://your-server-ip-or-domain:4000/api/Register?email=${email}&pass=${pass}`;
        const res = await fetch(url);
        const data = await res.json();
  
        if (data.data === 'valid') {
          console.log('Registration is valid!');
        } else {
          console.log('Not valid');
        }
      } catch (error) {
        console.error('Error:', error);
      }
    };
  
    // ... (other code)
  }



//Notes
//npm install express body-parser
//node server.js