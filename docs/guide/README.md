#  Bootcamp Final Project
Created with 💛 by

<!-- ALL-CREATORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tr>
    <td align="center">
        <a href="https://github.com/LarissaGMalagoli">
        <img src="docs/guide/resources/larissa-malagoli.jpg" width="100px;" alt=""/><br />
        <sub>
            <b>Larissa Malagoli</b>
        </sub>
        </a><br />
        💫</a>
    </td>
    <td align="center">
        <a href="https://github.com/joutavm">
        <img src="docs/guide/resources/joao-magalhaes.jpg" width="100px;" alt=""/><br />
        <sub>
            <b>Joutavm</b>
        </sub>
        </a><br />
        💻</a>
    </td>
    <td align="center">
        <a href="https://github.com/mogmeli">
        <img src="docs/guide/resources/murilo-preccaro.jpg" width="100px;" alt=""/><br />
        <sub>
            <b>Mogueno</b>
        </sub>
        </a><br />
        🧙‍</a>
    </td>
    <td align="center">
        <a href="https://github.com/pedro-cattel">
        <img src="docs/guide/resources/pedro-cattel.jpeg" width="100px;" alt=""/><br />
        <sub>
            <b>Pedro Cattel</b>
        </sub>
        </a><br />
        🍻</a>
    </td>
    <td align="center">
        <a href="https://github.com/wagnernegrao">
        <img src="docs/guide/resources/wagner-negrao.jpg" width="100px;" height="100px;" alt=""/><br />
        <sub>
            <b>Wagner Negrao</b>
        </sub>
        </a><br />
        🔥</a>
    </td>
  </tr>

</table>

<!-- markdownlint-restore -->
<!-- prettier-ignore-end -->

<!-- ALL-CREATORS-LIST:END -->
# Development

* Java 11 properly installed.
* Node.js v10 or superior.

Add the folowing Enviroment variables to your project:

### Step 1
```SCOPE``` and ``APPLICATION`` should have the values - ``local`` or ``test`` for the desired development ecosystem.

```local``` uses the H2 database for the DB operations, and ``test`` uses the Fury Test database. (MYSql)

### Step 2

``SECRET_TOKEN`` variable should be created with a secure key for the correct functioning of the JWT protocol.


## Fury

You may test and run the app though fury:

```
 fury test
 fury run
```