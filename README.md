# LiteraluraX

LiteraluraX es un catálogo de libros desarrollado en **Java** utilizando **Spring Boot** y **PostgreSQL**. Este proyecto permite interactuar con la API Gutendex, sincronizar libros, buscar autores, y realizar análisis de datos sobre libros y autores.

## Funcionalidades Principales

1. **Sincronización de Libros:**
   - Permite sincronizar libros desde la API Gutendex mediante una búsqueda por término.

2. **Listar Libros por Idioma:**
   - Lista todos los libros disponibles en un idioma específico.

3. **Top 10 Libros Más Descargados:**
   - Muestra los 10 libros con más descargas registrados en la base de datos.

4. **Buscar Autor por Nombre:**
   - Busca un autor en la base de datos por su nombre.

5. **Listar Autores Vivos en un Año Específico:**
   - Devuelve una lista de autores vivos en un año específico.

6. **Interfaz de Menú Interactivo:**
   - Interacción mediante consola para acceder a las funcionalidades.

---

## Tecnologías Utilizadas

- **Lenguaje:** Java 17+
- **Framework:** Spring Boot 3.2.3
- **Base de Datos:** PostgreSQL 16
- **Gestor de Dependencias:** Maven 4
- **Cliente HTTP:** RestTemplate
- **Serialización JSON:** Jackson

---

## Configuración del Proyecto

### Requisitos Previos

1. **Java JDK 17+** instalado.
2. **PostgreSQL 16** configurado y en ejecución.
3. **Maven** configurado en tu sistema.

### Variables de Entorno
Configura las siguientes variables de entorno para la conexión a la base de datos:

```plaintext
DB_URL=jdbc:postgresql://localhost:5432/literalurax
DB_USERNAME=tu_usuario
DB_PASSWORD=tu_contraseña
```

---

## Ejecución del Proyecto

### 1. Clonar el Repositorio

```bash
git clone https://github.com/tu-usuario/LiteraluraX.git
cd LiteraluraX
```

### 2. Construir el Proyecto

```bash
mvn clean install
```

### 3. Ejecutar la Aplicación

```bash
mvn spring-boot:run
```

---

## Uso del Menú Interactivo

Al iniciar la aplicación, aparecerá un menú interactivo en la consola:

```plaintext
--- LiteraluraX Menu ---
1. Sincronizar libros desde la API
2. Listar libros por idioma
3. Mostrar el top 10 de libros más descargados
4. Buscar un autor por nombre
5. Listar autores vivos en un año específico
6. Salir
Seleccione una opción:
```

### Ejemplo de Uso

1. Sincronizar libros ingresando un término de búsqueda:
   ```plaintext
   Ingrese el término de búsqueda para sincronizar libros: programming
   Libros sincronizados exitosamente.
   ```

2. Listar libros por idioma:
   ```plaintext
   Ingrese el idioma (ejemplo: en): en
   Book{id=1, title='Java Programming', language='en', downloadCount=5000}
   ```

3. Buscar un autor por nombre:
   ```plaintext
   Ingrese el nombre del autor: Charles Dickens
   Author{id=1, name='Charles Dickens', birthYear=1812, deathYear=1870}
   ```

---

## Endpoints Disponibles

### Libros
- **Sincronizar Libros:** `GET /books/sync-books?query={query}`
- **Listar por Idioma:** `GET /books/by-language?language={language}`
- **Top 10 Más Descargados:** `GET /books/top-downloaded`

### Autores
- **Buscar por Nombre:** `GET /authors/search?name={name}`
- **Autores Vivos en Año:** `GET /authors/alive-in-year?year={year}`

---

## Estructura del Proyecto

- **`model`:** Clases de entidad para `Author` y `Book`.
- **`repository`:** Interfaces para interactuar con la base de datos.
- **`service`:** Lógica de negocio.
- **`controller`:** Controladores REST para los endpoints.
- **`api`:** Cliente para la API Gutendex.

---

## Contribución

1. Haz un fork del repositorio.
2. Crea una nueva rama:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Realiza tus cambios y crea un commit:
   ```bash
   git commit -m "feat: nueva funcionalidad"
   ```
4. Sube los cambios a tu repositorio:
   ```bash
   git push origin feature/nueva-funcionalidad
   ```
5. Abre un Pull Request en el repositorio original.

---

## Licencia
Este proyecto está bajo la Licencia MIT. Puedes consultarla en el archivo `LICENSE` incluido en el repositorio.
