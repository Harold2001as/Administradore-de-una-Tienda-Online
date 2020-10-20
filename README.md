# Administradore-de-una-Tienda-Online
El proyecto consiste en crear, actualizar, eliminar productos en java con Apache NetBeans conectado con la base de datos DBeaver con el cliente

## Codigo de la base de datos

create table perfiles(
perfil_id int not null,
nombre varchar(20) not null,
constraint perfiles_PK primary key(perfil_id)
)

create table usuarios(
usuario_id int not null,
nombre varchar(100) not null,
telefono varchar(15) not null,
direccion varchar(30) not null,
email varchar(50) not null,
Contraseña varchar(10) not null,
edad int,
n_compras int not null,
perfil_id int not null,
constraint usuarios_PK primary key(usuario_id),
constraint usuarios_FK foreign key(perfil_id) references perfiles(perfil_id),
constraint email_uq unique (email)
)

create table proveedores(
proveedor_id int not null,
nombre varchar(50) not null,
telefono varchar(15) not null,
direccion varchar(30) not null,
constraint proveedores_PK primary key(proveedor_id)
)

create table categorias(
categoria_id int not null,
nombre varchar(50) not null,
descripcion text,
stock int not null,
constraint categorias_PK primary key(categoria_id)
)

create table productos(
producto_id serial not null,
nombre varchar(50) not null,
descripcion text,
precio float not null,
stock int not null,
fecha date not null,
imagen text not null,
proveedor_id int not null,
categoria_id int not null,
constraint productos_PK primary key(producto_id),
constraint productos_FK foreign key(proveedor_id) references proveedores(proveedor_id),
constraint productos2_FK foreign key(categoria_id) references categorias(categoria_id)
)

create table pedido_historial(
historial_id text not null,
fecha timestamp not null,
estado varchar(20) not null,
cantidad_producto int not null,
usuario_id int not null,
producto_id serial not null,
constraint pedido_historial_PK primary key(historial_id),
constraint pedido_historial_FK foreign key(usuario_id) references usuarios(usuario_id),
constraint pedido_historial2_FK foreign key(producto_id) references productos(producto_id)
)

create table carrito(
carrito_id varchar(11) not null,
fecha date not null,
cantidad_producto int not null,
producto_id serial not null,
constraint carrito_PK primary key(carrito_id),
constraint carrito_FK foreign key(producto_id) references productos(producto_id)
)

/INSERTS/

---PERFILES
insert into perfiles(perfil_id,nombre) values (1,'cliente');
insert into perfiles(perfil_id,nombre) values (2,'administrador');

---USUARIOS
insert into usuarios(usuario_id,nombre,telefono,direccion,email,contraseña,edad,n_compras,perfil_id)
values(1032235389, 'Nombre1','6987975','Cra80 #11-45','correo1@gmail.com','12345',19,5,1);
insert into usuarios(usuario_id,nombre,telefono,direccion,email,contraseña,edad,n_compras,perfil_id)
values(1027249263, 'Nombre2','2832353','Cra45 #21-34','correo2@gmail.com','12345',20,3,1);
insert into usuarios(usuario_id,nombre,telefono,direccion,email,contraseña,edad,n_compras,perfil_id)
values(1002220619, 'Nombre3','5286974','Cra40 #10-56','correo3@gmail.com','12345',18,7,2);
insert into usuarios(usuario_id,nombre,telefono,direccion,email,contraseña,edad,n_compras,perfil_id)
values(1001420619, 'Juan Pablo Zapata','52869754','crr40 #101 b7','correo@1.edu.co','pablo',19,20,2);
insert into usuarios(usuario_id,nombre,telefono,direccion,email,contraseña,edad,n_compras,perfil_id)
values(1001423589, 'pedro Pablo mesa','69879754','crr80 #1 b7','correo@2.edu.co','hola',19,20,1);
insert into usuarios(usuario_id,nombre,telefono,direccion,email,contraseña,edad,n_compras,perfil_id)
values(1058723589, 'alfredo quiroz','33379754','crr80 #1 b7','correo4@gmailcom','123456',25,5,1);

---PROVEEDORES
insert into proveedores(proveedor_id,nombre,telefono,direccion)
values(1,'Madera Fina','4563456','Cra56 #34-45');
insert into proveedores(proveedor_id,nombre,telefono,direccion)
values(2,'Aguas brisa','2832345','Cra65 #45-89');
insert into proveedores(proveedor_id,nombre,telefono,direccion)
values(3,'Granja MAyor','4352354','Cra45 #34-23');

---CATEGORIAS
insert into categorias(categoria_id,nombre,descripcion,stock)
values(1,'Hogar','Productos de la casa','12');
insert into categorias(categoria_id,nombre,descripcion,stock)
values(2,'Deportes','Productos deportivos','15');
insert into categorias(categoria_id,nombre,descripcion,stock)
values(3,'Tecnologia','Productos tecnologicos','10');

---PRODUCTOS
insert into productos(nombre,descripcion,precio,stock,fecha,imagen,proveedor_id,categoria_id)
values('Celular','Xiaomi',500000,50,'2020-10-09','Celular.png',1,3);
insert into productos(nombre,descripcion,precio,stock,fecha,imagen,proveedor_id,categoria_id)
values('Tennis','Nike',550000,20,'2020-10-09','Tennis.png',2,2);
insert into productos(nombre,descripcion,precio,stock,fecha,imagen,proveedor_id,categoria_id)
values('Cama','Base cama',1000000,10,'2020-10-09','Cama.png',3,1);
select * from productos 

---PEDIDO_HISTORIAL
insert into pedido_historial(historial_id,fecha,estado,cantidad_producto,usuario_id,producto_id)
values('103223538911',now(),'Pendiente',5,1032235389,1);
insert into pedido_historial(historial_id,fecha,estado,cantidad_producto,usuario_id,producto_id)
values('102724926322',now(),'Entregado',9,1027249263,2);
insert into pedido_historial(historial_id,fecha,estado,cantidad_producto,usuario_id,producto_id)
values('102724926333',now(),'Entregado',7,1027249263,3);

---CARRITO
insert into carrito(carrito_id,fecha,cantidad_producto,producto_id)
values('10322353891','2020-10-09',10,1);
insert into carrito(carrito_id,fecha,cantidad_producto,producto_id)
values('10272492632','2020-10-09',15,2);
insert into carrito(carrito_id,fecha,cantidad_producto,producto_id)
values('10322353893','2020-10-09',12,3);
