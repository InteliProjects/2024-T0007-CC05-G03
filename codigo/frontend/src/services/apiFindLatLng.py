import requests

def obter_latitude_longitude(nome_lugar, api_key):
    url = 'https://maps.googleapis.com/maps/api/geocode/json'
    parametros = {'address': nome_lugar, 'key': api_key}
    resposta = requests.get(url, params=parametros)
    dados = resposta.json()
    
    if resposta.status_code == 200:
        if dados['status'] == 'OK':
            latitude = dados['results'][0]['geometry']['location']['lat']
            longitude = dados['results'][0]['geometry']['location']['lng']
            return latitude, longitude
        else:
            print(f'Erro ao obter as coordenadas para o local "{nome_lugar}": {dados["error_message"]}')
            return None, None
    else:
        print(f'Erro na solicitação: código de status {resposta.status_code}')
        return None, None

# Substitua 'sua_api_key' pela sua própria chave da API do Google Maps
api_key = 'AIzaSyC0xCvNpxb9JFCphCIqeDwC5mWfVZqE_JY'

nome_lugar = input('Digite o nome do lugar: ')
latitude, longitude = obter_latitude_longitude(nome_lugar, api_key)

if latitude is not None and longitude is not None:
    print(f'A latitude de {nome_lugar} é {latitude} e a longitude é {longitude}.')
