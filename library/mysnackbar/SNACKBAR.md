# snackBar module使用说明
```
TSnackbar.make(mSnackRootView, message, TSnackbar.LENGTH_SHORT)
                .setPromptThemBackground(prompt)
                .setCallback(new TSnackbar.Callback() {
                    @Override
                    public void onDismissed(TSnackbar TSnackbar, @DismissEvent int event) {
                        super.onDismissed(TSnackbar, event);
                        switch (event) {
                            case DISMISS_EVENT_TIMEOUT:
                                try {
                                    snackViewDismissWhenTimeOut(prompt);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                        }
                    }
                })
                .show();

```