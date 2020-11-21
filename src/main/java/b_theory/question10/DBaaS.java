package b_theory.question10;

public class DBaaS {

    //todo A
    // What is DBaaS (Database as a service)?
    // Answer: Database as a service (DBaaS) is the process of application owners paying an outside provider that
    // launches and maintains a cloud database for storage, as opposed to having the application owners control the
    // database themselves.

    //todo B
    // Name 2 examples of DBaaS.
    // 1 Amazon RDS
    // 2 Amazon DynamoDB

    //todo C
    // Name and explain 2 benefits of using DBaaS
    // 1 Short-Lived Databases
    // If you need databases to serve as back ends for continuous integration testing, DBaaS will allow you to rapidly
    // provision the databases, populate them with test data and then delete them when they are no longer needed.
    // Having the database provisioned for you makes it far faster and simpler to build the required automation for
    // the testing environment.
    // 2 A Microservices Design: DBaaS can be particularly helpful, even in a production environment, if you are using
    // a microservices design composed of a very large number of databases. Even if you have the internal expertise,
    // you may not want to invest the time and effort in deploying all those databases. DBaaS can get you
    // into production significantly faster.

    //todo D
    // Name and explain 1 drawback of using DBaaS
    // 1 IO-Bound Workloads: If your database has IO-bound workloads, you may need very powerful hardware,
    // including high-end CPUs, terabytes of memory and very fast storage. In this case, you may not find a DBaaS
    // provider that offers a configuration that will meet your needs.

    //todo E
    // What other -aaS do you know?
    // 1 Saas, Software as a service, model in which software is used and purchased by an online subscription rather
    // than getting license, installing and using it as desktop software
    // 2 Iaas, Infrastructure as a service, model by which computing resources are provided virtually.
    // 3 Paas, Platform as a service, cloud computing model which provides a cloud base where you can test and run
    // your applications.

    //todo F
    // In your opinion which aaS are the most useful and should be integrated first.
    // Answer: PaaS or platform as a service model provides you computing platforms which typically includes operating
    // system, programming language execution environment, database, web server. technically
    // It is a layer on top of IaaS as the second thing you demand after Infrastructure is platform.

}
