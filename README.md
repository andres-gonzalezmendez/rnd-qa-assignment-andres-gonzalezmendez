Backbase QA Assignment

Author: Andrés González Méndez

# Deliverables

## Manual test cases

Manual test cases were written to cover the following features of the **web app**:

| **Feature** | **File with test cases**                                              |
|-------------|-----------------------------------------------------------------------|
| Owners      | [owners.feature](/web-test/src/test/resource/features/owners.feature) | 
| Pets        | [pets.feature](/web-test/src/test/resource/features/pets.feature)     |

Notes:
* They only cover the following "happy path" scenarios:
    * List all owners.
    * Add new owner.
    * Add new pet to an owner.
* They are written in Gherkin language and stored into feature files.
* They work for both manual and automated executions.

## Automated test reports

### Prerequisites to run automated test cases
* Docker
* JDK 20
* Maven

### How to run API tests
* Use the `docker-compose.yml` file to start the application by running the following command in the root folder:
```
docker-compose up
```
* Navigate to `api-test` folder by running the following command in the root folder:
```
cd api-test
```
* Run the following command to build the project and generate the test report:
```
mvn clean test
```
* Find test report in the following path:
```
/api-test/src/test/resources/reports
```

### How to run Web tests
* Use the `docker-compose.yml` file to start the application by running the following command in the root folder:
```
docker-compose up
```
* Navigate to `web-test` folder by running the following command in the root folder:
```
cd web-test
```
* Run the following command to build the project and generate the test report:
```
mvn clean test
```
* Find test report in the following path:
```
/web-test/src/test/resources/reports
```

# Results

## Manual test cases

[Manual test report](/web-test/src/test/resources/reports/manual-test-report.txt)

* No bugs were found when executing the manual test cases

## Automated tests

### API tests

* **Owners**

| **Test**                                 | **Endpoint**                       | **Result** |
|------------------------------------------|------------------------------------|------------|
| Adds a pet owner                         | POST /owners                       | PASS       |
| Delete an owner by Id                    | DELETE /owners/{ownerId}           | FAIL       |
| Lists pet owners                         | GET /owners                        | FAIL       |
| Update a pet owner's details             | PUT /owners/{ownerId}              | PASS       |

* **Pets**

| **Test**                                 | **Endpoint**                       | **Result** |
|------------------------------------------|------------------------------------|------------|
| Adds a pet to an owner                   | POST /owners/{ownerId}/pets        | FAIL       |
| Creates a pet                            | POST /pets                         | FAIL       |
| Deletes a pet by Id                      | DELETE /pets/{petId}               | FAIL       |
| Gets a pet by owner and pet Ids          | GET /owners/{ownerId}/pets/{petId} | PASS       |
| Gets a pet by pet Id                     | GET /pets/{petId}                  | FAIL       |
| Lists pets                               | GET /pets                          | FAIL       |
| Updates owner's pet by owner and pet Ids | PUT /owners/{ownerId}/pets/{petId} | FAIL       |
| Updates pet by pet Id                    | PUT /pets/{petId}                  | FAIL       |

Note: more information on automatically generated report.

### Web tests

* **Owners**

| **Test**              | **Result** |
|-----------------------|------------|
| List all pet owners   | PASS       |
| Add a pet owner       | PASS       |

* **Pets**

| **Test**                | **Result** |
|-------------------------|------------|
| Add new pet to an owner | PASS       |
