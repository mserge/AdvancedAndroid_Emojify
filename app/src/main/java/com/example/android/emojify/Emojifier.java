package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by mserge on 04.03.2018.
 */
//  (1): Create a Java class called Emojifier
public class Emojifier {
    private static final String TAG = "Emojifier";

    //  (2): Create a static method in the Emojifier class called detectFaces() which detects and logs the number of faces in a given bitmap.
   public static void detectFaces(Context context, Bitmap bitmap){
       FaceDetector detector = new FaceDetector.Builder(context)
               .setTrackingEnabled(false)
               .setLandmarkType(FaceDetector.ALL_LANDMARKS)
               .build();
       Log.d(TAG, "Start detecting..");
       Frame frame = new Frame.Builder().setBitmap(bitmap).build();
       SparseArray<Face> faces = detector.detect(frame);
       Log.d(TAG, "Detected " + faces.size() + " faces.");

       for (int i = 0; i < faces.size(); ++i) {
           Face face = faces.valueAt(i);
           Log.d(TAG, "Face found " + face.toString());
//           for (Landmark landmark : face.getLandmarks()) {
//               int cx = (int) (landmark.getPosition().x * scale);
//               int cy = (int) (landmark.getPosition().y * scale);
//               canvas.drawCircle(cx, cy, 10, paint);
//           }
       }
       detector.release();
    }
}
