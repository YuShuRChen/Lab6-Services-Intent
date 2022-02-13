package com.example.lab6_services_intent;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class DemoService extends IntentService {
    private static final String ACTION_DEMO = "com.example.lab6_services_intent.action.DEMO";

    private static final String GOODBYE_MESSAGE = "com.example.lab6_services_intent.extra.GOODBYE_MESSAGE";
    private String goodbyeMessage;

    public DemoService() {
        super("DemoService");
    }

    public static void startActionDemo(Context context, String goodbyeMessage) {
        Intent intent = new Intent(context, DemoService.class);
        intent.setAction(ACTION_DEMO);
        intent.putExtra(GOODBYE_MESSAGE, goodbyeMessage);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (action.equals(ACTION_DEMO)) {
                this.goodbyeMessage = intent.getStringExtra(GOODBYE_MESSAGE);
                handleActionDemo(goodbyeMessage);
            } else {
                // if we had other actions we would handle them here
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionDemo(String goodbyeMessage) {
        Toast.makeText(DemoService.this, "Service started", Toast.LENGTH_SHORT).show();

        synchronized (this) {
            try {
                wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stopSelf();
    }
}