package org.training.core.interceptors;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.training.core.model.PostsModel;

public class ValidateInterceptorDemo implements ValidateInterceptor {
    @Override
    public void onValidate(Object model, InterceptorContext ctx) throws InterceptorException {
        if (model instanceof PostsModel){
            final PostsModel posts= (PostsModel) model;

            String code=posts.getPid();

            if (BooleanUtils.isFalse(StringUtils.isAlphanumeric(code)) || code.contains(" ")) {
                throw new InterceptorException("This is custom interceptor : you cannot use this pid");
            }
        }

    }
}
