# Saltwater backend for Manatee chat

Manatee chat is lightweight web chat application for anyone who wants to communicate online without much overhead 
like facebook, twitter or any other chat platform.

Saltwater is a back-end side of Manatee chat project build with Scala using Play framework.

build status:
   * master : &nbsp;[![Build Status](https://travis-ci.com/wisaTong/Saltwater.svg?branch=master)](https://travis-ci.com/wisaTong/Saltwater)
   * develop : &nbsp;[![Build Status](https://travis-ci.com/wisaTong/Saltwater.svg?branch=develop)](https://travis-ci.com/wisaTong/Saltwater)

## Prerequisite
   * JDK 8
   * sbt (>= 1.2.3)

## Installation
Clone the repository and start your own server.

Simple as that.

```bash
$ git clone https://github.com/wisaTong/Saltwater.git
$ cd Saltwater   
$ sbt run

```

### Standard commands
   * `sbt run` - start a local development server
   * `sbt clean` - clean target/
   * `sbt compile` - compile changed source files
### Test and code coverage
   * `sbt test` - run tests
   * `sbt coverage test` - run test coverage
   * `sbt coverageReport` - generate html coverage report

### Other resources
* [Github wiki](https://github.com/wisaTong/Saltwater/wiki)
* [Iteration plans](https://github.com/wisaTong/Saltwater/wiki/Iteration-plans) (tasks in Asana also documented here)
* [Asana - project manager](https://app.asana.com/0/859032763601310/864258955335348) (Asana account needed)
* [Issues](https://github.com/wisaTong/Saltwater/issues)

#### related project:
* [Freshwater project - frontend for Manatee chat](https://github.com/wisaTong/Freshwater)
