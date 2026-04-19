# 🌿 Luontopeli
Yleiskatsaus
Luontopeli on Android-sovellus, jossa käyttäjä lähtee luontoretkelle ja kirjaa havaintojaan: kasveja, eläimiä ja muita luontokohteita. Sovellus laskee askelia, tallentaa GPS-reitin, ottaa kuvia, tunnistaa lajeja ML Kitillä ja synkronoi havainnot Firebaseen.


# Tehdyt ominaisuudet:
## Viikko 1 — 🎨 Material Design 3 + Navigaatio
M3-teema (väripaletti, typografia, muodot),
Bottom navigation bar,
NavHost + composable-reitit,
MVVM-kansiorakenne,
Placeholder-näkymät

## Viikko 2 — 👟 Anturit – Askelmittari & Gyroskooppi
SensorManager + SensorEventListener,
TYPE_STEP_DETECTOR (askelet),
TYPE_GYROSCOPE (kääntely),
WalkSession Room-entiteetti,
ACTIVITY_RECOGNITION-lupa

## Viikko 3 — 🗺️ GPS + OpenStreetMap (osmdroid)
Android LocationManager (GPS + verkko -fallback),
osmdroid – OpenStreetMap (ei API-avainta),
GeoPoint – sijaintipiste,
Polyline – reitin piirto,
Marker – havainnon sijainti,
Accompanist Permissions

## Viikko 4 — 📷 CameraX + Kuvat
CameraX Preview + AndroidView,
ImageCapture.takePicture(),
NatureSpot Room-entiteetti,
Coil – AsyncImage kuvien näyttöön,
Room-tietokannan versiointi (v2)

## Viikko 5 — 🌿 ML Kit – Kasvintunnistus
ImageLabeling on-device,
InputImage-muunnos,
Luottamuskynnys (threshold),
Luonto-avainsanojen suodatus,
ClassificationResult sealed class

## Viikko 6 — ☁️ Firebase – Auth, Firestore & Storage
Firebase Auth (anonyymi kirjautuminen),
Firestore callbackFlow + SnapshotListener,
Firebase Storage – kuvan lataus,
Offline-ensin -strategia (synced-kenttä),
DiscoverScreen – muiden havainnot
