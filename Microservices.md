# Microservices
This is a short introduction into the top of microservices.

### What are microservices
>"In short, the microservice architectural style is an approach to developing a single application as a suite of small services, each running in its own process and communicating with lightweight mechanisms, often an HTTP resource API. These services are built around business capabilities and independently deployable by fully automated deployment machinery. There is a bare minimum of centralized management of these services, which may be written in different programming languages and use different data storage technologies.”

*- - James Lewis and Martin Fowler - -*

### Characteristics of microservices
- **Componentization via Services**
  
  Componentizing your application by breaking it down into services.
  A Component is a unit of software that is independently replaceable und upgradeable. Services are out-of-process components   who communicate with mechanisms such as a web service request or remote procedure call. 
  The first reason to use services is the goal to deploy them independently and not to have the need to deploy the whole     
  application. The second reason is to have explicit interfaces. If the interface of a service changes – do versioning.

- **Organized around Business Capabilities**
  
  Conway‘s Law 
  > „Any organization that designs a system (defined broadly) will produce a design whose structure is a copy of the organization's communication structure.” 

  The result is that siloed functional teams lead to silod application architectures. Therefore better split up teams into services organized around business capability. These teams should be cross-functional (UI, DB, Middleware). The size of the team should fed by two pizza = no moren than a dozen people.
  
- **Products not Projects**
   
  The development team should own a product over its full lifetime. It takes full responsibility for the software in production. "You build it, you run it." 

- **Smart endpoints and dumb pipes**
 
  In difference to the Enterprise Service Bus where the smarts lie in the communication mechanism in microservices you use smart endpoints and dump pipes. A Service should be as decoupled and cohesive as possible – more like filters in UNIX – and  receive a request, apply the logic and at the end produce the response. This is done the RESTful way and not by complex protocols.
The two protocols used most commonly are HTTP request-response with resource API's and lightweight messaging. The messaging between services goes by remote procedure calls instead of in-process calls within a monolithic application.

- **Decentralized Governance & Data Management**
  
  As mentioned before the dev team is responsible for the service the whole time, the choice of the dev language, the data storage option, and the maintenance when operating the service. Each Service should has its own DB. However this can lead to inconsistency. Microservice architectures emphasize transactionless coordination between services, with explicit recognition that consistency may only be eventual consistency and problems are dealt with by compensating operations. This results in effort but trade-off is worth as long as the costs of fixing mistakes is less than the cost of lost business under greater consistency.

- **Infrastructure Automation**

  Continous Delivery (build software that it can be deployed to producation at any time)
Build pipeline with automated tests (unit, acceptance, intergration, uat, performance) and deployment
Managing microservices with monitoring and logging tools

- **Design for failure**

  Any service call could fail at anytime – be prepared
„If something can go wrong, it will go wrong“
Circuit Breaker Pattern (Abschaltung bei bestimmter Fehlerrate, Fallback-Case)

- **Evolutionary Design**

  Use Versioning if interface for service has changed -> Compatibility still exists

### Benefits
+ Technology Heterogenety

  You can use different programming languages to write your services -> Java, Go, etc. all communicating via REST http
  
+ Resilience
  
  with use of e.g. Hystrix patterns (Timeout, Circuit Breaker, Load shredder) are introduced to make the system more resilient (fallbacks defined)

+ Scaling

  With deployment in the cloud you can scale easily by deploying more services if needed.

+ Ease of Deployment
 
  Small autonomous services, so they can be easily deployed

+ Organizational Alignment
 
  Better align architecture to organization, minimize number of people working on the code, ui expert, coder etc in one team for a service.

+ Composability

  reuseable composable microservices
  
+ Optimizing for Replaceability

  small services loosely coupled therefore no pain to replace

### Drawbacks
+ Distribution

  remote calls are more expensive than in-process calls, more risk to failure

+ Eventual Consistency
 
  Maintaining strong consistency is extremely difficult for a distributed system, which means everyone has to manage eventual consistency. Not all node are up-to-date

+ Operational Complexity
  
  You need a mature operations team to manage lots of services, which are being redeployed regularly. DevOps Culture needed, Continious Integration necessary to build up

### Users of microservices

- Netflix ![alt text](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "Logo Title Text 1")
- Amazon ![alt text](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "Logo Title Text 1")
- The Guardian ![alt text](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "Logo Title Text 1")
- SoundCloud ![alt text](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "Logo Title Text 1")
- SAP Hybris ![alt text](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "Logo Title Text 1")

### Differentiation to a Monolith

### Differentiation to SOA
You can also:
  - Type some Markdown on the left
  - See HTML in the right
  - Magic


  - Import and save files from GitHub, Dropbox, Google Drive and One Drive
  - Drag and drop files into Dillinger
  - Export documents as Markdown, HTML and PDF

Markdown is a lightweight markup language based on the formatting conventions that people naturally use in email.  As [John Gruber] writes on the [Markdown site][df1]

> The overriding design goal for Markdown's
> formatting syntax is to make it as readable
> as possible. The idea is that a
> Markdown-formatted document should be
> publishable as-is, as plain text, without
> looking like it's been marked up with tags
> or formatting instructions.

This text you see here is *actually* written in Markdown! To get a feel for Markdown's syntax, type some text into the left window and watch the results in the right.

### Version
1.0.0

### Tech

Dillinger uses a number of open source projects to work properly:

* [AngularJS] - HTML enhanced for web apps!
* [Ace Editor] - awesome web-based text editor
* [markdown-it] - Markdown parser done right. Fast and easy to extend.
* [Twitter Bootstrap] - great UI boilerplate for modern web apps
* [node.js] - evented I/O for the backend
* [Express] - fast node.js network app framework [@tjholowaychuk]
* [Gulp] - the streaming build system
* [keymaster.js] - awesome keyboard handler lib by [@thomasfuchs]
* [jQuery] - duh

And of course Dillinger itself is open source with a [public repository][dill]
 on GitHub.

### Installation

Dillinger requires [Node.js](https://nodejs.org/) v4+ to run.

You need Gulp installed globally:

```sh
$ npm i -g gulp
```

```sh
$ git clone [git-repo-url] dillinger
$ cd dillinger
$ npm i -d
$ NODE_ENV=production node app
```

### Plugins

Dillinger is currently extended with the following plugins

* Dropbox
* Github
* Google Drive
* OneDrive

Readmes, how to use them in your own application can be found here:

* [plugins/dropbox/README.md] [PlDb]
* [plugins/github/README.md] [PlGh]
* [plugins/googledrive/README.md] [PlGd]
* [plugins/onedrive/README.md] [PlOd]

### Development

Want to contribute? Great!

Dillinger uses Gulp + Webpack for fast developing.
Make a change in your file and instantanously see your updates!

Open your favorite Terminal and run these commands.

First Tab:
```sh
$ node app
```

Second Tab:
```sh
$ gulp watch
```

(optional) Third:
```sh
$ karma start
```

### Docker
Dillinger is very easy to install and deploy in a Docker container.

By default, the Docker will expose port 80, so change this within the Dockerfile if necessary. When ready, simply use the Dockerfile to build the image.

```sh
cd dillinger
docker build -t <youruser>/dillinger:latest .
```
This will create the dillinger image and pull in the necessary dependencies. Once done, run the Docker and map the port to whatever you wish on your host. In this example, we simply map port 80 of the host to port 80 of the Docker (or whatever port was exposed in the Dockerfile):

```sh
docker run -d -p 80:80 --restart="always" <youruser>/dillinger:latest
```

Verify the deployment by navigating to your server address in your preferred browser.

### N|Solid and NGINX

More details coming soon.

#### docker-compose.yml

Change the path for the nginx conf mounting path to your full path, not mine!

### Todos

 - Write Tests
 - Rethink Github Save
 - Add Code Comments
 - Add Night Mode

License
----

MIT


**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [@thomasfuchs]: <http://twitter.com/thomasfuchs>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [keymaster.js]: <https://github.com/madrobby/keymaster>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]:  <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
