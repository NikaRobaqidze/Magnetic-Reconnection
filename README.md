# Magnetic-Reconnection

## HIGH-LEVEL SUMMARY

Magnetic reconnection is a phenomenon where magnetic field lines break and reconnect, releasing energy. Studying it helps us understand solar flares, space weather, and fusion energy for applications like improved forecasting and controlled fusion. Our team develop algorithm that determine this process based on data from satellites of NASA.

## PROJECT DETAILS

Project contains two part.

1) (Final-algorithm) Algorithm created on Java (using InteliJ Idea) that render JSON format file. We use downloaded data and parsing it from [NASA official resources](https://spdf.gsfc.nasa.gov/pub/data/ace/merged/4_min_merged_mag_plasma/).

2) (Demo) Node.js (Express) web-application, that read data from rendered JSON file and demonstrate it with graphics. Also get analyze text about data;

## Usage

- Java (SE) JDK version 17.0.8.1;  
- Node.js;
- ChatGPT API key;

## Installation & run

1) Run [Main.java](DataParser/src/main/java/ge/Odysseus/Main.java) after the end of successful compilation file [MR-data.json](DataParser/src/main/java/ge/Odysseus/sources/MR-data.json) will be created/rewrited;

2) Locate to "/Server" and run [npm](https://www.npmjs.com/) to install all packages:
```bash
cd /Server && npm install
```

3) After the end of packages successful installations, run Web-Application (on localhost) [app.js](Server/app.js);
```bash
npm run app
```
or run manually
```bash
node app.js
```

4) Web-application will run on port 3000 (localhost);
   open: http://localhost:3000

## Result preview

In opened window will rendered 4 chart that show parametres changing of detected Magnetic Reconnection from NASA Satelites data. Unde charts it is "Get analyze" button, after click it send data (promted) to ChatGPT using API to render easy to understand analyze text. Response delay may be more than 30 second. :)
