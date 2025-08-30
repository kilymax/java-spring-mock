
# Java Spring Mock 

<a name="readme-top"></a>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Simple Java Spring REST mock example

<!-- Demo video on YouTube [here](https://www.youtube.com/watch?v=4na8KFVoyZM&list=PL4lVqWiqXeK15HICGgnRiJTThgfftHEyt&index=5) -->

<!-- <p align="right">(<a href="#readme-top">back to top</a>)</p> -->


### Built With

* Java 17.0.12 2024-07-16 LTS
* Java Spring
* Maven
* Lombok
* Tomcat
* Configuration with https://start.spring.io/

<!-- <p align="right">(<a href="#readme-top">back to top</a>)</p> -->


<!-- GETTING STARTED -->
## Getting Started

<!-- ### Prerequisites -->

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/lostie21yo/funeral-app2
   ```
2. With Node installed run in console
   ```sh
   npm install
   npm start
   ```
<!-- <p align="right">(<a href="#readme-top">back to top</a>)</p> -->


<!-- USAGE EXAMPLES -->
## Usage

1. Run JAR
   ```sh
      nohup java -jar JavaSpringMock-0.0.1-SNAPSHOT.jar --server.port=8044 -xms1g -xmx2g > JS-8044.log &
   ```
2. Request example
   ```sh
    {
      "rqUID": "58dgtf565j8547f64ke7",
      "clientId": "3050000000000000000",
      "account": "30500000000000000001",
      "openDate": "2020-01-01",
      "closeDate": "2025-01-01"
    }
    ```
3. Response example
    ```sh
    {
      "rqUID": "58dgtf565j8547f64ke7",
      "clientId": "3050000000000000000",
      "account": "30500000000000000001",
      "currency": "RU",
      "balance": "16000.00",
      "maxLimit": "50000.00"
    }
    ```
4. For mock debugging you can send JSON request using Postman or CURL.

<!-- <p align="right">(<a href="#readme-top">back to top</a>)</p> -->


<!-- CONTACT -->
## Contact

Ilya K - [Telegram](https://t.me/leoncox) - leon.coxsw@gmail.com

Project Link: [Java Spring Mock](https://github.com/kilymax/java-spring-mock)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<div align="center">
© 2025 GitHub, Inc.
</div>
