# Microservices
This is a short introduction into the topic of microservices.

### What are microservices
>"In short, the microservice architectural style is an approach to developing a single application as a suite of small services, each running in its own process and communicating with lightweight mechanisms, often an HTTP resource API. These services are built around business capabilities and independently deployable by fully automated deployment machinery. There is a bare minimum of centralized management of these services, which may be written in different programming languages and use different data storage technologies.”

*- - James Lewis and Martin Fowler - -*

### Characteristics of microservices
- **Componentization via Services**
  
  Microservices are all about componentizing your application by breaking it down into single services. The resulting services should be idenpendently replaceable and upgradeable. Their inter-processs communication can go e.g. via mechanisms such as a HTTP-based REST. One benefit of the componentization into such services is the possiblity to deploy these services independently and not to have the need to deploy the whole application. The second benefit is to have explicit interfaces because they are needed for the inter-process communication. Therefore the interface description is not only documentation and you cannot so easily ignore it and as a result couple the service closely together.

- **Organized around Business Capabilities**
  
  Conway‘s Law 
  > „Any organization that designs a system (defined broadly) will produce a design whose structure is a copy of the organization's communication structure.” 

  The result of Conway's law is that siloed functional teams lead to silod application architectures. Therefore it is better to split up teams into services organized around business capability. These teams should be cross-functional i.e they should contain experts of the relevant technical areas (DB, UI, Middleware, etc.). The size of the team should be measured by the fact that a team can be fed by two pizza = no more than a dozen people.
  
- **Products not Projects**
   
  The development team should own a product(service) over its full lifetime. It also takes full responsibility for the software in production. The credo is "You build it, you run it." 

- **Smart endpoints and dumb pipes**
 
  In difference to the Enterprise Service Bus(ESB) in the SOA area where the smarts lie in the communication mechanism, microservices should use smart endpoints and dump pipes. A Service should be as decoupled and cohesive as possible – more like filters in UNIX – and receive a request, apply the logic and at the end produce the response. This is done the RESTful way and not by complex protocols. The two protocols used most commonly are HTTP request-response with resource API's and lightweight messaging. The messaging between services goes by remote procedure calls instead of in-process calls within a monolithic application.

- **Decentralized Governance & Data Management**
  
  As mentioned before the development team is responsible for the service the whole lifetime, the choice of the programming language, the data storage option, and the maintenance when operating the service. Each Service should has its own DB. However this can lead to inconsistency. Microservice architectures emphasize transactionless coordination between services, with explicit recognition that consistency may only be eventual consistency and problems are dealt with by compensating operations. This results in effort but trade-off is worth as long as the costs of fixing mistakes is less than the cost of lost business under greater consistency.

- **Infrastructure Automation**

  The keyword here is Continous Delivery. You should build the software in order to be able to deploy it to production at any time. A build pipeline with automated tests (unit, acceptance, intergration, user acceptance, performance) and final deployment is needed for high automation. For managing the high amount of microservices your need monitoring and logging tools.

- **Design for failure**

  As we have to deal with a distributed system a service call can fail because of network or machines at anytime and it will („If something can go wrong, it will go wrong“). Therefore you should be prepared. There exists several technologies and patterns to improve the resilience of the microservice architecture. One example is the Circuit Breaker Pattern. It tracks the number of successful and failed requests. If the error rate is above a configured threshold, the circuit breaker blocks the request so they fail immediately. After a defined period the client can try again and if successfl the circuit breaker opens. Futhermore a fallback logic can be defined in case a request fails like returning a default or cached value.


- **Evolutionary Design**

  As the service is evolving also its API may change. To be non-disruptive use versioning in case interface for the service has changed. 

### Benefits
+ **Technology Heterogenety**

  You are free in the choice of the programming languages to write your services (Java, Go, etc.). Their communication is inter-process via HTTP-based REST or lightweigt messaging and use non-propriatery protocols. Therefore you can pick the right technology to fulfill the job. As a result each service can have a different programming language and database, however this might not be the optimal case. Because trying out a new technology is only limited to one service it is easier to do so and be on the technological edge. However analyse the platform, tooling and libraries available.
	
+ **Resilience**
  
  As we have seen before in the section "Design for failure" the remote calls will fails. However more and more specific patterns and technologies (Hystrix, Timeout pattern, Circuit Breaker pattern, etc) are introduced to make the system more resilient so these should be applied. If you look at the case of the failure of a monolith everything stops, however with running on multiple machines you can reduce failure. With microservices (distributed system) a system can be build to handle the total failure of services and degrade functionality accordingly.


+ **Scaling**

  A monolith can only scale as a whole instead in the microservice environment only the necessary services need to be scaled. With deployment in the cloud you can scale easily by deploying more services if needed. The cloud environment is therefore beneficial for scaling as creating new instances is comfortable and can be done on-demand for each service.
 
		
+ **Ease of Deployment**
 
  The services in a microservice architecture should be small and autonomous, so they can be easily deployed. The services should be small in terms of codebase and functionality. Therefore they should be focused on doing ONE thing WELL. The Single Responsibility Principle "Gather together those things that change for the sam reason, and separate those things that change for different reasons" should be applied. Small services are good for less dependencies but you then have more services which are more complex to handle Autonomous means that services need to be able to change independently of each other, and be deployes by themselves without requiring consumers to change. The services expose an technology-agnostic API to communicate with consumers (e.g. other services).
In contrast to microservices a monolith needs to be deployed fully when changing only one line. This reults in a high impact and risk and releases are in larger intervals. However changes sum up between the releases and therefore also the risk gets higher. With microservices you only make changes to one independent service and deploy it independent of the rest of the system. As a result in an error case a fast rollback is possible as you can identify the service and of course you can get out new functionality faster.


+ **Composability**

  Microservices can be reused by applications addressing different channels (mobile app, wearable device, etc). This opens up for resuse of functionality.
  
+ **Optimizing for Replaceability**

  As we have small services which are loosely coupled therefore no pain to replace them. With services being small in sitze the cost to replace them with a better implementation or even delete them is much easier to manage.


### Drawbacks
+ **Distribution**

  As in distributed systems remote calls are necessary this is more expensive than in-process calls in a monotlith. Furthermore remote calls have a higher risk to fail.

+ **Eventual Consistency**
 
  Maintaining strong consistency is extremely difficult for a distributed system, which means everyone has to manage eventual consistency. This eventually results in not all nodes being up-to-date.

+ **Operational Complexity**
  
  By having lots a services which are being redeployed regularly you need operations team to manage this. The DevOps culture is benefical and Continious Integration really necessary to build up to handle complexity.

### Users of microservices
- Netflix 

  ![alt text](https://github.com/RaphaelReply/MicroServices/raw/master/pictures/netflix.png "Netflix")

- Amazon 

  ![alt text](https://github.com/RaphaelReply/MicroServices/raw/master/pictures/amazon.png "Amazon")

- The Guardian 

  ![alt text](https://github.com/RaphaelReply/MicroServices/raw/master/pictures/guardian.png "The Guardian")

- SoundCloud 

  ![alt text](https://github.com/RaphaelReply/MicroServices/raw/master/pictures/soundcloud.png "SoundCloud")

- SAP Hybris 

  ![alt text](https://github.com/RaphaelReply/MicroServices/raw/master/pictures/hybris.png "Logo Title Text 1")

### Differentiation to a Monolith
 - **Changing the Code**

   Changes to monolith result in building and deploying the whole application whereas changes in microservices architecture result in building and deploying only the relevant services. Therefore the release cycles of a monolith are longer as rollbacks in case of errors are also expensive.
   
 - **Scaling**
 
   The scaling of a monolith is done horizontally by running many instances e.g. behind a load balancer. This comes with scaling of the complete application rather than only the necessary parts as it can be done with microservices.
 
- **Maintenance**

  A monolith has a large code base with thousand lines of code where potentially nobody understands it all. Therefore fixing bugs is difficult and time consuming. 
   
- **Failure**

   As in a monolith all modules are running within the same process, a bug in any module, such as a memory leak, can potentially bring down the entire process. In a microservice environment a service failure may degrade the functionality but does not bring down the whole.
  

- **Evolution**  

  The adoption of a new technology or framework results in the needs to rewrite the entire application which is time and cost intensive. This is a huge barrier to adopt to the newest technologies even if they are considerably better.
		 

### Differentiation to SOA
 - **Same general idea**
	Both approaches share the idea of an architecture that consists of a set of services. Therefore you could think of microservices as a special approach of SOA.

	
 - **Communication differs**
Instead of web service standards (WS-*) like SOAP, WSDL, etc microservices use simpler, lightweight protocols such as REST which evolved out of the web. Furthermore instead of a ESBs which contain high complexity microservices use rather dumb messaging systems and keep the smarts in the services. 

   An **ESB (Enterprise Service Bus)** provides a set of functionalities like messaging, routing, transformations and business process management. 
It's general function is the orchestration of the interoperability between applications, web services, databases, email servers, and so on that speak different protocols.
One example of an ESB is Mule.

   A **message broker** simply allows the developer to exchange message with the publish and subscribe pattern to enable asynchronous processing.
As a result you can keep the response times low.
One example of an Message broker is RabbitMQ.

	
### Microservice Architecture Parts
##### API Gateway

 A Microservice environment needs a gateway. A Gateway is the only entity exposed to the outside world, which allows access to the microservices behind it. It handles the requests by simply routing it to the appropriate service or fanns them out to multiple services. Protocol translation is also a main task for the API Gateway. Furthermore a Gateway can be responsible for
-	API Metering
-  Centralized Authentication/Authorization
-  Load Balancing

![alt text](https://github.com/RaphaelReply/MicroServices/raw/master/pictures/gateway.png "API Gateway")


One example for this is Netflix Zuul.


##### Service Discovery
As there are numerous of services each service has to register itself with a service registry to be known of and accessible. In case another servie wants to communicate with the service it asks the service registry server for the base url of the service.
You can also register multiple instances in a service registry to do load balancing this way.
The two ways for service discovery are:
- Client-side discorvery

  On doing a request to a service, the client receives the location identifier the service by querying the Service Registry, which knows all service instances.
![alt text](https://github.com/RaphaelReply/MicroServices/raw/master/pictures/clientside.png "Client-side discovery")
- Server-side service discovery

  On doing a request to a service, the client makes a request via a router that runs at a well known location. The router queries a service registry, which might be built into the router, and forwards the request to an available service instance.
![alt text](https://github.com/RaphaelReply/MicroServices/raw/master/pictures/serverside.png "Server-side discovery")

One example client-side discovery is Netflix Eureka in combination with the Ribbon client.

##### Messaging
In addition to remote procedure calls via REST which are synchronous also asynchronous messaging is needed. Therefore a message broker with message queues are necessary to also enable message buffering, re-submission  and so on.
One example for this is RabbitMQ. 


##### Remote Procedure Incovation
A Microservices environment is built to sustain failures of contained services with implemented pattern like Circuit Breaker. This ensures to keep the system going. Here A Circuit Breaker provides generally spoken an alternative behaviour in case a service is not reachable.
This way the system gracefully switches to fallback behavior until the system recovers, rather than entire system suffering the ripple effects of failed service.
One example to apply respective pattern to make the rpc calls more resilient is Hystrix.


### Demo

Get the code
```sh
$ git clone https://github.com/RaphaelReply/MicroServices.git <your_location>
```

Build it
```sh
$ cd <your_location>/SyskoEdExample
$ mvn package
```

Push it to cloud foundry
```sh
$ cf login
$ cf push
```

Do requests
```sh
$ curl -i -X DELETE https://mongodb-syskoed.cfapps.us10.hana.ondemand.com
$ curl -i -X GET https://mongodb-syskoed.cfapps.us10.hana.ondemand.com
$ curl -i -H "Content-Type: application/json" -X POST -d '{"salutation":"Herr","firstname":"Zlatan","lastname":"Ibrahimovic"}' https://mongodb-syskoed.cfapps.us10.hana.ondemand.com
```


### 12 factor app
With applying the 12 factor app methodoloy you build apps that:
- Use declarative formats for setup automation, to minimize time and cost for new developers joining the project;
- Have a clean contract with the underlying operating system, offering maximum portability between execution environments;
- Are suitable for deployment on modern cloud platforms, obviating the need for servers and systems administration;
- Minimize divergence between development and production, enabling continuous deployment for maximum agility;
- And can scale up without significant changes to tooling, architecture, or development practices.
		
**1. Codebase**

   Use one codebase which is tracked in revision control (e.g. Git). It should exists a one to one correlation between the codebase and the app. 
			
- Multiple codesbases -> violation! -> not an app it is a distributed system
- Multiple apps sharing codebase -> violation! -> Put shared code into libraries and include via dependency manager

There exist normally many deploys of the app as running instances on production sites, staging sites or on local developer environment.
	
**2. Dependencies**

   Explicitly declare e.g. in a dependency declaration manifest and isolate dependencies to ensure that no implicit dependenies "leak in" from the surrounding system. As a result the app never relies on implicit existence of system-wide packages or on the implicit existence of any system tools.

**3. Config**
   
   Store config data in the environment by using environment variables instead of hard-code it in the source code to be also language- and OS-agnostic. The alternative is to use property files which might get checked in by error to the repository. This is necessary as config data e.g. resource handles to databases, normally varies between deploy enviroment and should therefore not be hardcoded in code.
		
**4. Backing services**

You should treat backing services as attached resources and access them via a URL or other locator/credentials stored in the config data. Backing services are consumed by the app over the network in operation like Datastores(MySQL), Messaging/Queueing systems(RabbitMQ), SMTP services for outbound mails(Postfix), and caching systems(Memcached). You should be able to swap services without changes to code, with only config changes.

**5. Build, release, run**

Strictly separate build and run stages. The build stage is a transform which converts a code repo into an executable bundle known as a build. Using a version of the code at a commit specified by the deployment process, the build stage fetches vendors dependencies and compiles binaries and assets. The release stage takes the build produced by the build stage and combines it with the deploy’s current config. The resulting release contains both the build and the config and is ready for immediate execution in the execution environment. The run stage (also known as “runtime”) runs the app in the execution environment, by launching some set of the app’s processes against a selected release. Every release should have its unique ID. Any change must create a new release. See http://semver.org/ for versioning semantics
	
**6. Processes**

Execute the app as one or more stateless processes which share nothing. Data persistence must be done in a stateful backing service i.e. database. Sticky sessions are a violation of twelve-factor.
	
**7. Port binding**
	
Export services via port binding e.g. access service under localhost:8080.  A routing layer handles routing requests from a public facing hostname to the port-bound web process, such as for example  Jetty for Java.

**8. Concurrency**
  
  Scale out via the process model and handle the diverse workload by assigning each type of work to a process type like in a microservice architecture.
	
**9. Disposability**
	
Maximize robustness with fast startup and graceful shutdown.
	
**10. Dev/prod parity**

Keep development, staging, and production as similar as possible.
	
**11. Logs**

Treat logs as event streams which means to use log routers for this purpose like Log4j to stdout in development process to view all the issues directly as a stream.

**12. Admin processes**
		Run admin/management tasks as one-off processes
		one-off administrative or maintenance tasks 
		One-off admin processes should be run in an identical environment	
		
### Useful stuff

Here are some resource which are interesting to look up to get more details about micro services

* [Microservices blog](www.microservices.io) 
* [Martin Fowler - Microservices](http://martinfowler.com/articles/microservices.html)
* [12factor apps](http://12factor.net/)
* [YaaS](www.yaas.io)
* [Netflix techblog](http://techblog.netflix.com/)		
