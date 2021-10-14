package com.sinsisao.billiardswaiting.Model;

import android.content.Context;

public interface Storable {
    void save(Context a_context);
    void load(Context a_context);
}
