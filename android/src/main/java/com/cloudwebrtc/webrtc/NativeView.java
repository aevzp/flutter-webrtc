package com.cloudwebrtc.webrtc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.Map;

import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.platform.PlatformView;

class NativeView implements PlatformView {
    // keys that should be in creation params
    private final static String KEY_SDP_FILE_PATH = "sdpFilePath";


    private final FrameLayout root;

    @SuppressWarnings({"unused", "RedundantSuppression"})
    NativeView(@NonNull Context context, int id, @Nullable Map<String, Object> creationParams, EventChannel.EventSink eventSink) {
        String sdpFilePath = getKeyFromMap(creationParams, KEY_SDP_FILE_PATH, "");
        // building view
        root = new FrameLayout(context);
//        VideoAudioControllerView view = new VideoAudioControllerView(context);
//        view.setEventSink(eventSink);
//        view.playSdpFile(sdpFilePath);
//        view.setId(R.id.view_a_v_c);
//        root.addView(view, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    @SuppressWarnings({"unchecked", "SameParameterValue"})
    private <T> T getKeyFromMap(Map<String, Object> map, String key, T defaultValue) {
        T value;
        if (map != null && map.containsKey(key)) {
            try {
                value = (T) map.get(key);
            } catch (Exception e) {
                value = defaultValue;
            }
        } else {
            value = defaultValue;
        }
        return value;
    }

    @NonNull
    @Override
    public View getView() {
        return root;
    }

    @Override
    public void dispose() {
        // disposing media components in our custom view
//        ((VideoAudioControllerView) root.findViewById(R.id.view_a_v_c)).dispose();
    }
}