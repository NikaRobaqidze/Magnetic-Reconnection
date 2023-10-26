import Express from "express";
import { ChatGPTAPI } from "chatgpt";

import fs from 'fs';
import path from "path";

const express = Express;
const app = express();

app.set('view engine', 'ejs');

app.use(express.urlencoded({ extended: false }));

app.use(express.json({
    type: ['application/json', 'text/plain']
}))

const DataJsonPath = path.resolve(path.dirname(process.cwd()), 'DataParser', 'src', 'main', 'java', 'ge', 'Odysseus', 'sources', 'MR-data.json');

const DataKeys = {

    "Field-Magnitude-Average": 7,
    "Plasma-Proton-density": 13,
    "Plasma-Temperature": 14,
    "Plasma-flow-speed": 16
}

app.get('/', (req, res) => {

    const data = JSON.parse(fs.readFileSync(DataJsonPath, 'utf-8') || '[]');
    res.render('index', {data: data});
});

app.post(

    '/Get-Analyze',

    async (request, response) => {

        const api = new ChatGPTAPI(
            {
                apiKey: '<API-Key>'
            }
        );

        const data = JSON.parse(fs.readFileSync(DataJsonPath, 'utf-8') || '[]');
        const values = data.map(row => parseFloat(row[DataKeys[request.body.content]]));

        const chatGPTResponse = await api.sendMessage(
            `Analyze this ${request.body.content.split('-').join(' ')} in Magnetic Reconnection value sequence: ${values.join(', ')}`
        );

        response.json({status: true, Analyze: chatGPTResponse.text});
    }
);

app.listen(3000, () => console.log("Server work."));