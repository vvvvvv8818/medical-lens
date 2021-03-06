/*
 * Copyright (C) The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.wehealed.medical_lens;

import android.util.Log;
import android.util.SparseArray;

import com.example.wehealed.medical_lens.GraphicOverlay;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.Line;
import com.google.android.gms.vision.text.Text;
import com.google.android.gms.vision.text.TextBlock;

import java.util.ArrayList;
import java.util.List;

/**
 * A very simple Processor which gets detected TextBlocks and adds them to the overlay
 * as OcrGraphics.
 * TODO: Make this implement Detector.Processor<TextBlock> and add text to the GraphicOverlay
 */
public class OcrDetectorProcessor implements Detector.Processor<TextBlock> {

    private GraphicOverlay<OcrGraphic> graphicOverlay;
    public SparseArray<TextBlock> items;


    @Override
    public void receiveDetections(Detector.Detections<TextBlock> detections) {
        graphicOverlay.clear();
        //SparseArray<TextBlock> items = detections.getDetectedItems();
        items = detections.getDetectedItems();

        for (int i = 0; i < items.size(); ++i) {
            TextBlock item = items.valueAt(i);

            if (item != null && item.getValue() != null) {
                //Log.d("WeHealed Processor", "Text detected! " + item.getValue());
/*
                List<Text> all_lines = new ArrayList<>();
                List<? extends Text> texts = item.getComponents();

                for (Text t: texts) {
                    all_lines.add(t);
                }*/



/*
                List<Text> all_lines = new ArrayList<>();
                List<? extends Text> texts = item.getComponents();

                for (Text t: texts) {
                    all_lines.add(t);
                }*/


                OcrGraphic graphic = new OcrGraphic(graphicOverlay, item, i);
                graphicOverlay.add(graphic);
            }
        }
    }

    public SparseArray<TextBlock> getItems() {
        return items;
    }

    @Override
    public void release() {
        graphicOverlay.clear();
    }

    OcrDetectorProcessor(GraphicOverlay<OcrGraphic> ocrGraphicOverlay) {
        graphicOverlay = ocrGraphicOverlay;
    }

    // TODO:  Once this implements Detector.Processor<TextBlock>, implement the abstract methods.
}
