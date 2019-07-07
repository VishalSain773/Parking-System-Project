# Parking-System-Project
A project to help you park your car at a particular slot and 
will tell you the cost for the parking once checked out at 1Rs/ per minute

## Technologies Used :- 
1. Front-end :- Angular 7
2. Back-end :- Java
3. Database :- MongoDB


## How to run the code :- 
1. Clone the repository in your local using `git clone https://github.com/VishalSain773/Parking-System-Project.git.`
2. Now install mongoDb+robo 3t in your system and start the mongo db server by typing mongod in command prompt.
> (Note: Make sure to set the enviornment variables path for mongoDB. If your mongoDB server is not starting please go to your C:/ drive and create a folder data/db)
3. As the mongoDb server is running now open robo3T and create a new database with the name of "parkinglotrepo"(all small cases).
4. Inside parkinglotrepo create a new collection using right click<create collection. Name this new collection as SlotFlag(Please take care of the camelcase).
5. Inside SlotFlag add data in the following form:- 


-  {  "slotNumber" : "1", <-------- create as many  slots as you want.
-    "booked" : false,
-    "_class" : "com.vishal.parkinglot.jsonobject.SlotFlag" }

**DONE? Nice, we are almost there.**

6. Open the service code and in the command prompt run `gradle build` (make sure to use gradle version 4.4 or above).
7. Run the jar file in service/build/libs using `java -jar 'Jar File Name'`(use TAB in cmd for auto insert the file name).

**GOOD! Now you service code is running and now its time to run the front end.**

8. Open the UI folder and in the command prompt run `npm install` which will install the node modules.
9. Now FINALLY run `ng serve` to start the front end server
10. Just open your google chrome and in the url type `localhost:4200`
