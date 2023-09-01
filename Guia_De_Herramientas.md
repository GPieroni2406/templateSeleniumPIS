Herramientas a utilizar:
-> Eclipse (Puede ser la utlima version)
-> Jenkins (Puede ser la utlima version)
-> Git (Puede ser la utlima version)
-> Git Extensions (Puede ser la utlima version)
-> Java (Se deja la version del equipo)

-> Selenium WebDriver  (Por ahora 3.14)
-> Plugin TestNG for Eclipse (7.7.0 En principio)
-> Maven (Se importa desde el pom.xml)
-> AShot (Se importa desde el pom.xml)
-> ExtentReports (Se importa desde el pom.xml)



Instalación de Git:

    Ir a Git: https://git-scm.com/

    Descargar el instalador adecuado para tu sistema operativo.

    Ejecuta el instalador descargado y sigue las instrucciones en pantalla para completar la instalación.

Instalación de Git Extensions:

    Visita el sitio web de Git Extensions: https://gitextensions.github.io/

    En la página de descargas, selecciona la versión adecuada para tu sistema operativo (Windows).

    Descarga el instalador y ejecútalo.

    Sigue las instrucciones en pantalla para completar la instalación de Git Extensions.

Instalación de Jenkins:

    Visita el sitio web oficial de Jenkins: https://www.jenkins.io/

    En la página de inicio, busca la sección "Download" o "Get Jenkins" y elige la opción adecuada para tu sistema operativo (generalmente Windows).

    Descarga el archivo de instalación (normalmente un archivo WAR).

    Abre una terminal o línea de comandos y navega hasta la ubicación donde descargaste el archivo WAR.

    Ejecuta el comando java -jar jenkins.war para iniciar el servidor Jenkins.

    Abre tu navegador web y accede a http://localhost:8080. Sigue las instrucciones en pantalla para completar la configuración de Jenkins.

Instalación de Eclipse:

    Visita el sitio web de Eclipse: https://www.eclipse.org/

    En la página de inicio, busca la sección "Downloads" y elige el paquete de Eclipse adecuado para tu tipo de desarrollo (por ejemplo, Eclipse IDE for Java Developers).

    Descarga el instalador y ejecútalo.

    Sigue las instrucciones en pantalla para completar la instalación de Eclipse.

Instalación de Java:


    Visita el sitio web de AdoptOpenJDK: https://adoptopenjdk.net/

    Selecciona la versión de Java que deseas instalar y el sistema operativo correspondiente.

    Descarga el instalador o el archivo ZIP de la versión de Java seleccionada.

    Ejecuta el instalador o descomprime el archivo ZIP en una ubicación de tu elección.

    Configura la variable de entorno JAVA_HOME para que apunte al directorio de instalación de Java.

    Agrega la ruta al directorio bin de Java en la variable de entorno PATH.

El resto de los artefactos como AShot, ExtentReports se agregan directamente desde las dependencias en el pom.xml, de la siguiente forma:

		<dependency>
			<groupId>ru.yandex.qatools.ashot</groupId>
			<artifactId>ashot</artifactId>
			<version>1.5.4</version>
		</dependency>

        <dependency>
			<groupId>com.aventstack</groupId>
			<artifactId>extentreports</artifactId>
			<version>5.0.9</version>
		</dependency>

Instalación de Apache Maven:
    Accede al Mercado de Eclipse:
    En Eclipse, ve al menú "Help" (Ayuda) y selecciona "Eclipse Marketplace" (Mercado de Eclipse).

    Busca el Plugin de Maven:
    En la ventana del Mercado de Eclipse, en la barra de búsqueda, escribe "Maven" y presiona Enter.

    Instala el Plugin:
    Deberías ver el plugin "m2e - Maven Integration for Eclipse" en los resultados de búsqueda. Haz clic en "Go to the full listing" (Ir a la lista completa) para obtener más detalles.

    Instala el Plugin desde el Mercado:
    En la página del plugin "m2e - Maven Integration for Eclipse", haz clic en el botón "Install" (Instalar) para comenzar la instalación.

Instalación de Selenium WebDriver:
    Agrega la Biblioteca Selenium:
    Para agregar Selenium a tu proyecto en Eclipse, sigue estos pasos:

        Haz clic derecho en el proyecto en el Explorador de Proyectos de Eclipse.
        Selecciona "Build Path" (Ruta de Construcción) y luego "Configure Build Path" (Configurar Ruta de Construcción).
        En la pestaña "Libraries" (Bibliotecas), haz clic en "Add External JARs" (Agregar JARs Externos).
        Navega hasta el directorio donde tienes los archivos JAR de Selenium (generalmente en la carpeta libs de tu proyecto) y selecciona los archivos JAR necesarios (por ejemplo, selenium-java-x.x.x.jar).

    Aplica Cambios y Acepta:
    Una vez que hayas agregado los JAR de Selenium, haz clic en "Apply and Close" (Aplicar y Cerrar) o simplemente "OK" para cerrar la ventana de configuración de la ruta de construcción.

Instalación de TestNG (Java):

    En la ventana del Mercado de Eclipse, en la barra de búsqueda, escribe "TestNG" y presiona Enter.

    Instala el Plugin:
    Deberías ver el plugin "TestNG for Eclipse" en los resultados de búsqueda. Haz clic en "Go to the full listing" (Ir a la lista completa) para obtener más detalles.

    Instala el Plugin desde el Mercado:
    En la página del plugin "TestNG for Eclipse", haz clic en el botón "Install" (Instalar) para comenzar la instalación.
    User

    Luegos se pueden tener en el pom.xml las siguientes dependencias:
    		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>7.7.0</version>
			<scope>compile</scope>
		</dependency>

		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>reportng</artifactId>
			<version>1.2.2</version>
			<scope>test</scope>
		</dependency>

