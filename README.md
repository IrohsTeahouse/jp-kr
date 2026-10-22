# Kagami Geoul · projeto Android (piloto, Capítulo I)

RPG dark fantasy para aprender japonês e coreano, 100% offline.

## Gerar o .apk pelo GitHub (recomendado)

A cada envio para o repositório, a aba **Actions** compila o app sozinha
(`.github/workflows/gerar-apk.yml`). Baixe o **KagamiGeoul-apk** em
**Actions > última execução > Artifacts**.

O app é assinado sempre com a mesma chave (`android/app/kagami-debug.keystore`),
então cada versão nova instala por cima da anterior e o progresso é mantido.

## Gerar o .apk no computador

Precisa de Node.js (LTS) e Android Studio instalados.

```
npm install
npx cap sync android
npx cap open android
```

No Android Studio: espere o Gradle sincronizar e use
**Build > Build App Bundle(s) / APK(s) > Build APK(s)**.
O arquivo sai em `android/app/build/outputs/apk/debug/app-debug.apk`.

## Estrutura

- `www/` — o jogo (HTML, motor, histórias e fontes locais)
- `android/` — projeto Android gerado pelo Capacitor 6
- `assets/` — arte do ícone e da tela de abertura
- `capacitor.config.json` — nome e identificador do app (`com.kagamigeoul.app`)

Plugins: `@capacitor-community/text-to-speech` (voz nativa do Android) e
`@capacitor/app` (botão voltar).

As fontes (Shippori Mincho, Nanum Myeongjo, Spectral, IM Fell English SC,
IBM Plex Mono) vêm do Fontsource e usam a licença SIL Open Font License 1.1;
os arquivos de licença estão em `www/fonts/`.
