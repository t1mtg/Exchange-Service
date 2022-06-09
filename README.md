# Exchange Service
Alpha Bank test task


This service accesses the exchange rate service, compares current rates of the chosen currency and displays a gif depending on the course change.
The service processes request on the following endpoint:
```
http://localhost:8080/get//exchange/{currency}
```
Where `currency` is three-digit code of the required currency.

Example:
```
http://localhost:8080/exchange/get/EUR
```

Response:
```
url : https://giphy.com/gifs/smile-money-earth-WS0Z51IiviHukFDL61
 id : WS0Z51IiviHukFDL61
```


Instructions to build and run:
1. Clone this repo:
```
git clone https://github.com/t1mtg/Exchange-Service
```
2. Change directory to Exchange-Service
```
cd Exchange-Service
```
3. Build
 ```
gradlew build
```
4. Run
 ```
gradlew bootRun
```
