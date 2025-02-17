const express = require("express");
const mysql = require("mysql2");
const app = express();
const db = mysql.createConnection({
    host: "db",
    user: "root",
    password: "rootpassword",
    database: "testdb"
});
app.get("/", (req,res) =>{
    db.query("SELECT 'hello from MySQL' AS message", (err, result) =>{
        if (err) throw err;
        res.json(result[0]);
    })
})
app.listen(3000,() => console.log("backend running on port 3000"));