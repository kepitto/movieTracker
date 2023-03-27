To start the application:

1. docker-compose up
2. docker run --name postgres -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 -d postgres
3. Run KafkaApplication

To input data with postman:

1. Post http://localhost:8080/api/v1/kafka/sendMovie
2. Body e.g.:  
   {
   "movieName":"TEST",  
   "genre":"genreTest",  
   "rating":5,  
   "views":10000
   }
3. Send

To get all models:

1. Open Browser
2. http://localhost:8080/hype/getHype
3. See data

In logs you can see:  
Message sent...  
Message received...  
Average hype factor sent... (Aggregated topic)
HypeFactor received...
Database - Save...
Get Hype