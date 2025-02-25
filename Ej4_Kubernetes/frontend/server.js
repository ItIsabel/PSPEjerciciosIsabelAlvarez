const express = require ('express');
const axios = require ('axios');
const app = express ();
const port = 3000;

app.get('/',async(req, res) =>{
    try{
        //call the backend api using the kuberteness dns name
        const response = await axios.get ('http://backend-service:8000');
        res.send (`<h1>Frontend</h1> <p>Response from api: ${JSON.stringify(response.data)}</p>`);
    } catch (error) {
        res.send (`<h1>Error</h1><p> ${error.message}</p>`);
    }
});
app.listen(port, () => {
    console.log(`Frontend app listening on port ${port}`);
    });