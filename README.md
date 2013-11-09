I pass level 1.1 :)

## Get ready

[fork](https://help.github.com/articles/fork-a-repo) me and [clone](https://help.github.com/articles/fork-a-repo#step-2-clone-your-fork) your repository locally.

[install Maven](http://maven.apache.org/)

check your install: in the directory of the repo, run

```sh
mvn clean package
```

Build should be successful and 4 tests should pass

## See it working

Lauch the application

```sh
mvn jetty:run-war
```

Open your browser and navigate to

```sh
http://localhost:8080/ping
```

You should see the Json

```sh
{
  alive : true
}
```

## Deploy

Deploy and run your server so that the game can call it.
