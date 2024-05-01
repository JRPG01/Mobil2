# Importaciones del SKD de Firebase
import firebase_admin
import firebase_admin.messaging

# Arreglo con los tokens de los dispositivos
tokens = ["fsUNhwqgQ-Wj258eYTCd4p:APA91bGdg7rXz2DkgbbkQigkcHNhi7h6x1WnJv8vlP97lneYSYHIfqoi5w9St9ghKkdtrbttMffY5OhBGp_m-yxgkmX62omaLtlusdenjmgpDC-vudEm-PRnYp7xmhsGgO1msIPeyg2h"]

# Función para mandar las notificaciones
def mandarNoti(titulo, mensaje, tokens, dataObject = None):
    # Creación de la notificación
    noti = firebase_admin.messaging.MulticastMessage(
        notification = firebase_admin.messaging.Notification(
            title = titulo,
            body = mensaje
        ),
        data = dataObject,
        tokens = tokens
    )
    # Envío y confirmación de envío
    firebase_admin.messaging.send_multicast(noti)
    print("SE HA ENVIADO LA NOTIFICACION")

# Asignar credenciales provenientes del archivo api-key.json
cred = firebase_admin.credentials.Certificate('Clave_Privada.json')
firebase_admin.initialize_app(cred)
#print("DEBUGGER")

# Llamada el método para enviar una notificación
mandarNoti("Se va ha hacer o no la carnita acazada", "Quien lea esto se invita las Guamas", tokens)