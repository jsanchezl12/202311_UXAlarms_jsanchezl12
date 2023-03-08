## DOCUMENTACION MAQUETACIÓN WEB

1. Instalar Angular
```
npm install -g @angular/cli 
```

2. Crear proyecto
```
ng new bestDoc
```

3. Instalar Angular Material
```
ng add @angular/material
```
*_NOTA: Seleccionar el tema de Angular Material que se desea utilizar (Deep Purple/Amber)_*
4. Instalar JQuery
```
npm install jquery - save
```
5. Instalar Bootstrap
```
npm install bootstrap - save
```

6. Instala Popper.js
```
npm install popper.js - save
```
7. Se corre el proyecto
```
ng serve -o
```

8. Se configura el archivo angular.json en build
```
    "styles": [
        "@angular/material/prebuilt-themes/deeppurple-amber.css",
        "node_modules/bootstrap/dist/css/bootstrap.min.css",
        "src/styles.scss"
    ],
    "scripts": [
        "node_modules/jquery/dist/jquery.min.js",
        "node_modules/popper.js/dist/umd/popper.min.js",
        "node_modules/bootstrap/dist/js/bootstrap.min.js"
    ]
```

9. Se instala el paquete de type para el uso de jquery
```
npm i --save-dev @types/jquery
```

10. Se crea un componente
```
ng generate component dashboard
ng generate component components/best-d-grid
ng generate component components/best-d-item
ng generate component components/best-d-noticias
ng generate component components/best-d-noticias-item
ng generate component components/best-d-semaforo
ng generate component components/best-d-semaforo-item
ng generate component components/bestDControls/best-de-toggle-view
```

11. Se crea un modulo
```
ng generate module documentos
ng generate component new-document --module=documentos
ng generate component lista --module=documentos
```

12. Entre mas campos en la URL se debe ir de Mayor a Menor
```
{ path: 'documentos/new-document', component: NewDocumentComponent },
{ path: 'documentos', component: DocumentosComponent },
{ path: 'documentos/lista', component: ListaComponent },
```