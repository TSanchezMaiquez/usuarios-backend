* Dependencias:
![img.png](img.png)

* build.gradle:
  * 	implementation 'org.mapstruct:mapstruct:1.5.5.Final'
  
        annotationProcessor 'org.mapstruct:mapstruct-processor:1.5.5.Final'



* Añadir ficheros de base de datos a gitignore


REPOSITORIO: 

- @Repository
* Para mantener aislada la capa de dominio de la de infraestructura nos creamos nuestra
propia interface de persistencia, dentro de domain: usuarioPersistence
* Para poder hacer uso de los metodos de JpaRepository en infraestructura -> persistencia
nos hacemos una interface que extienda esa interface: UsuarioRepository
* El ultimo paso es crear en infraestructura -> persistencia una clase que implementa nuestra interface
UsuarioPersistence y tiene una propiedad privada de UsuarioRepository.

De esta forma hacemos uso de los metodos de jpa con la propiedad de UsuarioRepository y desvinculamos
nuestro dominio.

DTO:

- Implementar Serializable
- Constructor vacio


Service:

- En la clase que implementa la interface UsuarioService poner la anotacion Service


RestController:

- propiedad de la interface service

- anotacion @RestController
- @CrossOrigin: permite que los navegadores web realicen solicitudes al controlador 
 desde un origen diferente al de la aplicación. 
Si no la ponemos, cuando el frontend intente recuperar datos recibira el error: CORS error



Paginacion:

- extender  JpaSpecificationExecutor en UsuarioRepository
- Esto nos permitirá usar su metodo findAll 

            return usuarioRepository.findAll(specification, pageable);
        
-  Creamos un nuevo metodo en UsuarioPersitence que devuelve un objeto de tipo Page

         Page<Usuario> findAll(Pageable pageable, String filter);

- creamos un nuevo metodo en UsuarioService que devuelve tambien un objeto de tipo Page:
 
        Page<UsuarioDto> getUsersByCriteriaStringPaged(Pageable pageable, String filter);

- Desde UsuarioRestController llamamos al nuevo metodo del service: 

          @CrossOrigin
          @GetMapping(value = "/usuarios", produces = "application/json")
              public ResponseEntity<Page<UsuarioDto>> getUsersByCriteriaPaged(
              @RequestParam(value = "filter", required = false) String filter, Pageable pageable) {
    
              Page<UsuarioDto> usuarios = usuarioService.getUsersByCriteriaStringPaged(pageable,filter);
              return new ResponseEntity<Page<UsuarioDto>>(usuarios, HttpStatus.OK);
          }
- Este metodo del service llama a su vez al nuevo metodo de persistence:

          @Override
          @Transactional
              public Page<UsuarioDto> getUsersByCriteriaStringPaged(Pageable pageable, String filter) {
    
              Page<Usuario> usersPage = this.usuarioPersistence.findAll(pageable, filter);
              return usersPage.map(usuarioMapper::toDto);
          }
- Metodo findAll del repositorio:

          @Override
          public Page<Usuario> findAll(Pageable pageable, String filter) {
              UserSpecification specification = new UserSpecification(SearchCriteriaHelper.fromFilterString(filter));
              return usuarioRepository.findAll(specification, pageable);
          }
