/*
 * commons-tags - Copyright (C) 2009-2013 MSF. All rights reserved.
 */
package br.ojimarcius.commons.tags.format;

import br.ojimarcius.commons.tags.base.AbstractHtmlGeneratorTag;
import br.ojimarcius.commons.tags.util.TagUtils;
import br.ojimarcius.commons.util.CharSequenceUtils;
import br.ojimarcius.commons.util.DateUtils;
import java.io.IOException;
import javax.servlet.jsp.JspException;

/**
 * TODO : Descreva a classe.
 *
 * @author Marcius da Silva da Fonseca (sf.marcius@gmail.com)
 */
public class FormatDateTag extends AbstractHtmlGeneratorTag {

    private final String DEFAULT_PATTERN = "dd/MM/yyyy";
    private Object value;
    private String var;
    private String scope;
    private String pattern;
    private Boolean isPatternKey;

    public Object getValue() {
        return value;
    }

    public void setValue(final Object value) {
        this.value = value;
    }

    public String getVar() {
        return var;
    }

    public void setVar(final String var) {
        this.var = var;
    }

    public String getScope(final String defaultValue) {
        return CharSequenceUtils.isNotBlank(scope) ? scope : defaultValue;
    }

    public void setScope(final String scope) {
        this.scope = scope;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(final String pattern) {
        this.pattern = pattern;
    }

    public Boolean isPatternKey(final Boolean defaultValue) {
        return isPatternKey != null ? isPatternKey : defaultValue;
    }

    public void setIsPatternKey(final Boolean isPatternKey) {
        this.isPatternKey = isPatternKey;
    }

    @Override
    public void doTag() throws JspException, IOException {
        evaluateBody();
        if (CharSequenceUtils.isBlankOrNull(getVar())) {
            writeAssembledHtml();
        } else {
            String formatted = assembleHtml().toString();
            if (CharSequenceUtils.isBlankOrNull(formatted)) {
                formatted = null;
            }
            getJspContext().setAttribute(getVar(), formatted, TagUtils.getScope(getScope(TagUtils.SCOPE_PAGE)));
        }
    }

    @Override
    public CharSequence assembleHtml() throws JspException, IOException {
        if (CharSequenceUtils.isBlankOrNull(getPattern())) {
            // no pattern. use default
            return DateUtils.format(getValue(), DEFAULT_PATTERN);
        }
        final String resolvedPattern = isPatternKey(Boolean.FALSE) ? resolveMessage(getPattern(), true) : getPattern();
        return DateUtils.format(getValue(), resolvedPattern);
    }
}
