## Java

### Get Starting
See which is the Java SDK version used, into the project `pom.xml` file.
Example
```
<java.compiler.version>11</java.compiler.version>
```
means we are using Java SDK version 11.0

### Which IDE can we use ?
We are using IntelliJ, and we suggest that any developer of this project continue with this IDE.

### To Run the Tests
To run the tests use the command `mvn test` or  `fury test`

### Contribution Guidelines

Please be sure to read the [Contribution Guidelines](./../../CONTRIBUTE.md). It contains important information and practices the team agreed.

## Deployment
We work with **Release Process**.
For more information about it, please refer to [Fury Release Process Documentation](https://docs.furycloud.io/#/lang-es/fury/rp?id=release-process)

The followings are the general steps to correctly deploy this application:
1. Once you have all the features tested that you want to deploy inside develop branch, you must document them in the [Changelog](./../../CHANGELOG.md) file
2. Create release branch with the according version. Example of branch's name: `release/1.0.1`
3. Create the Pull Request to trigger the Continuous Integration process. This will create the candidate version in Fury. Example candidate version's name: `1.0.1-rc-1`
4. Merge the Pull Request into master. Fury will create the productive version when this has done. Example of productive version's name: `1.0.1`
5. Deploy this productive version into `production` scope and do regression tests plus new features tests.
6. Document the release's new features in GitHub. [Example](https://github.com/mercadolibre/fury_mastercard-interchange-rate/releases/tag/1.1.3)
7. It's advisable that you watch the {app.name}'s Dashboards to make sure that the deploy has worked.

## Project Structure
This project follows [Interface-Based Programming](https://en.wikipedia.org/wiki/Interface-based_programming). Please read this wikipedia page in order to understand. 