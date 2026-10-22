package com.kagamigeoul.app;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

/**
 * Abre as configurações de voz (texto para fala) do Android.
 * Tenta, em ordem: a tela de texto para fala, a instalação de dados de voz
 * do mecanismo padrão e, por último, as configurações gerais.
 * Abre a tela direto, sem consultar o sistema antes, porque a partir do
 * Android 11 essa consulta volta vazia e nada acontecia ao tocar no botão.
 */
@CapacitorPlugin(name = "Voz")
public class VozPlugin extends Plugin {

    @PluginMethod
    public void abrirConfiguracoes(PluginCall call) {
        String[] telas = {
            "com.android.settings.TTS_SETTINGS",
            TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA,
            Settings.ACTION_SETTINGS
        };
        for (String tela : telas) {
            try {
                Intent intent = new Intent(tela);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().startActivity(intent);
                JSObject resultado = new JSObject();
                resultado.put("tela", tela);
                call.resolve(resultado);
                return;
            } catch (ActivityNotFoundException | SecurityException e) {
                // Esta tela não existe neste aparelho; tenta a próxima.
            }
        }
        call.reject("Nenhuma tela de configuração de voz foi encontrada neste aparelho.");
    }
}
