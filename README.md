- El proyecto inicializa con los siguientes 6 Usuarios registrados, a través de los cuales se puede ingresar a la app a traves de la pantalla de Login:
  
  usuario: amanda_fuentes@gmail.com, pass:af123
  usuario: yara_khalil@gmail.com, pass: yk123
  usuario: sara_ibrahim@outlook.com, pass: si123
  usuario: amad_ibrahim@gmail.com, pass:ai123
  usuario: reem_khaled@outlook.com, pass:rk123
  usuario: hiba_saleh@gmail.com, pass:is123

- Es posible registrar nuevos usuarios a través del SignUpPageFragment
- Todas la pantallas fueron implementadas con fragmentos a excepción de la SplashScreen que se implemento como un theme para la MainActivity.
- Todas las pantallas funcionales a excepcion de la ProfilePageFragment que solo muestra la imagen y el nombre del usuario sin implementar ninguna acción vinculada a sus elementos graficos.
- El fragmento HomePageFragment muestra los datos y las transacciones vinculadas al usuario logeado 
- El fragmento SendMoneyFragment elije de forma aleatoria un usuario a quien enviar dinero.
- El fragmento RequestMoneyFragment elije de forma aleatoria el usuario de quién se recibirá dinero.
- EL envío y el ingreso de dinero están funcionales, actualizandose los datos de los usuarios involucrados y registrandose las transacciones.
- Se utiliza la clase LocalDateTime para el registro de la fecha y hora de cada transacción realizada.

- 
- 
