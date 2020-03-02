package com.cmiov.framework.gateway.utils;

import java.util.Iterator;

/**
 * @author xzg
 */
public class StringCollectionUtil {

    /**
     * 为分隔符将集合转换为字符串
     *
     * @param <T> 集合元素类型
     * @param iterable {@link Iterable}
     * @param conjunction 分隔符
     * @return 连接后的字符串
     */
    public static <T> String join(Iterable<T> iterable, CharSequence conjunction) {
        if (null == iterable) {
            return null;
        }
        return join(iterable.iterator(), conjunction);
    }
    /**
     * 以 conjunction 为分隔符将集合转换为字符串<br>
     * 如果集合元素为数组、{@link Iterable}或{@link Iterator}，则递归组合其为字符串
     *
     * @param <T> 集合元素类型
     * @param iterator 集合
     * @param conjunction 分隔符
     * @return 连接后的字符串
     */
    public static <T> String join(Iterator<T> iterator, CharSequence conjunction) {
        return join(iterator, conjunction, null, null);
    }

    /**
     *  分隔符将集合转换为字符串<br>
     * 如果集合元素为数组、{@link Iterable}或{@link Iterator}，则递归组合其为字符串
     *
     * @param <T> 集合元素类型
     * @param iterator 集合
     * @param conjunction 分隔符
     * @param prefix 每个元素添加的前缀，null表示不添加
     * @param suffix 每个元素添加的后缀，null表示不添加
     * @return 连接后的字符串
     */
    public static <T> String join(Iterator<T> iterator, CharSequence conjunction, String prefix, String suffix) {
        if (null == iterator) {
            return null;
        }

        final StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        T item;
        while (iterator.hasNext()) {
            if (isFirst) {
                isFirst = false;
            } else {
                sb.append(conjunction);
            }

            item = iterator.next();
            if (item instanceof Iterable<?>) {
                sb.append(join((Iterable<?>) item, conjunction, prefix, suffix));
            } else if (item instanceof Iterator<?>) {
                sb.append(join((Iterator<?>) item, conjunction, prefix, suffix));
            } else if(item instanceof String) {
                sb.append(wrap(String.valueOf(item), prefix, suffix));
            }
        }
        return sb.toString();
    }

    public static <T> String join(Iterable<T> iterable, CharSequence conjunction, String prefix, String suffix) {
        if (null == iterable) {
            return null;
        }
        return join(iterable.iterator(), conjunction, prefix, suffix);
    }


    static String wrap(CharSequence str, CharSequence prefix, CharSequence suffix) {
        return nullToEmpty(prefix).concat(nullToEmpty(str)).concat(nullToEmpty(suffix));
    }
    public static String nullToDefault(CharSequence str, String defaultStr) {
        return (str == null) ? defaultStr : str.toString();
    }

    public static String nullToEmpty(CharSequence str) {
        return nullToDefault(str, "");
    }
}
