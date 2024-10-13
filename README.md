# Animal CRUD API
This API peforms CRUD operations on animal objects in a local database. Info below:

#Installation
-Acquire the project locally:
  -Download the project or clone it via "https://github.com/WillSan98/Crud-Api.git".
-Open the project in your IDE of choice.
- [`/src/main/resources/application.properties`](https://github.com/WillSan98/Crud-Api/blob/master/Assignment-4/src/main/resources/application.properties) file is the configuration for the MySQL database on your localhost.
- Ensure that your data base is running
  - Open XAMPP
  - Start Apache
  - Start MySQL
  - Click Admin to open the GUI for you database
  - Make sure the animal database is available for operations
-Build and run the main class for the project.

# API Endpoints
## Get a list of all the animal objects in the database
### Request
  Get: animals/all
  
  http://localhost:8080/animals/all

### Response
*Sample Response
  
   {
      "animalId" : 1
      "name" : "Husky"
      "scientificName" : "Canine lupus familiaris"
      "species" : "Dog"
      "habitat" : "Indoors"
      "description" : "A misc. dog description"
  }
  {
    "animalId" : 2
    "name" : "Domestic Short Hair"
    "scientificName" : "Felis catus"
    "species" : "Cat"
    "habitat" : "Indoors"
    "description" : "A misc. DSH description"
  }
  {
    "animalId" : 3
    "name" : "Persian"
    "scientificName" : "Felis catus"
    "species" : "Cat"
    "habitat" : "Indoors"
    "description" : "A misc. Persian Description"
  }
  
## Search an animal object by its ID
### Request
  Get: animals/{animalId}
  
  http://localhost:8080/animals/2

### Response

  {
    "animalId" : 2
    "name" : "Domestic Short Hair"
    "scientificName" : "Felis catus"
    "species" : "Cat"
    "habitat" : "Indoors"
    "description" : "A misc. DSH description"
  }
 

## Find a list of animals by peforming partial matches with a string by the name attribute
### Request
  Get: animals/match/{entry}

  http://localhost:8080/animals/match/Beetle
### Response

  {
    "animalId" : 7
    "name" : "Hercules Beetle"
    "scientificName" : "Dynastes hercules"
    "species" : "Beetle"
    "habitat" : "Rainforest"
    "description" : "A misc. hercules beetle description"
  }
  {
    "animalId" : 9
    "name" : "Blister Beetle"
    "scientificName" : "Meloidae"
    "species" : "Beetle"
    "habitat" : "Arid areas"
    "description" : "A misc. blister beetle Description"
  }

## Find a list of animals by their species attribute
### Request
  Get: animals?species=""

  http://localhost:8080/animals?species=beetle

### Response
[
  {
    "animalId" : 7
    "name" : "Hercules Beetle"
    "scientificName" : "Dynastes hercules"
    "species" : "Beetle"
    "habitat" : "Rainforest"
    "description" : "A misc. hercules beetle description"
  }
  {
    "animalId" : 9
    "name" : "Blister Beetle"
    "scientificName" : "Meloidae"
    "species" : "Beetle"
    "habitat" : "Arid areas"
    "description" : "A misc. blister beetle description"
  }
]

## Create a new animal object. (Like the demo it returns the whole database of animals objects.)
### Request
  Post: animals/new

  http://localhost:8080/animals/new
  *JSON body:
  {
    "animalId" : 72
    "name" : "Ladybug"
    "scientificName" : "Coccinellidae"
    "species" : "Beetle"
    "habitat" : "Grasslands"
    "description" : "A misc. ladybug description"
  }
  
### Response

  {
    "animalId" : 7
    "name" : "Hercules Beetle"
    "scientificName" : "Dynastes hercules"
    "species" : "Beetle"
    "habitat" : "Rainforest"
    "description" : "A misc. hercules beetle description"
  }
  {
    "animalId" : 9
    "name" : "Blister Beetle"
    "scientificName" : "Meloidae"
    "species" : "Beetle"
    "habitat" : "Arid areas"
    "description" : "A misc. blister beetle description"
  }
  {
    "animalId" : 72
    "name" : "Ladybug"
    "scientificName" : "Coccinellidae"
    "species" : "Beetle"
    "habitat" : "Grasslands"
    "description" : "A misc. ladybug description"
  }

## Update an animal object.
### Request
  Put: animals/update/{animalId}

  http://localhost:8080/animals/update/72
  *JSON body:
  {
    "animalId" : 72
    "name" : "Ladybug"
    "scientificName" : "Coccinellidae"
    "species" : "Beetle"
    "habitat" : "Mountains, Coniferous Forests"
    "description" : "A misc. ladybug description"
  }
### Response
  {
    "animalId" : 72
    "name" : "Ladybug"
    "scientificName" : "Coccinellidae"
    "species" : "Beetle"
    "habitat" : "Mountains, Coniferous Forests"
    "description" : "A misc. ladybug description"
  }
]
## Delete an Animal object. (Returns the remaining objects like the demo.)
### Request
  Delete: animals/delete/{animalId}

  http://localhost:8080/animals/delete/72
### Response

  {
    "animalId" : 7
    "name" : "Hercules Beetle"
    "scientificName" : "Dynastes hercules"
    "species" : "Beetle"
    "habitat" : "Rainforest"
    "description" : "A misc. hercules beetle description"
  }
  {
    "animalId" : 9
    "name" : "Blister Beetle"
    "scientificName" : "Meloidae"
    "species" : "Beetle"
    "habitat" : "Arid areas"
    "description" : "A misc. blister beetle description"
  }

  
