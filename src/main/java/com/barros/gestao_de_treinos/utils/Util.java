package com.barros.gestao_de_treinos.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Util {

    public static void iniciarAtributosEmBranco(Object obj) {
        if (obj == null) return;

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(obj) == null) {
                    Class<?> type = field.getType();

                    if (type == String.class) {
                        field.set(obj, "");
                    } else if (type == int.class || type == Integer.class) {
                        field.set(obj, 0);
                    } else if (type == long.class || type == Long.class) {
                        field.set(obj, 0L);
                    } else if (type == double.class || type == Double.class) {
                        field.set(obj, 0.0);
                    } else if (type == boolean.class || type == Boolean.class) {
                        field.set(obj, false);
                    } else if (List.class.isAssignableFrom(type)) {
                        field.set(obj, new ArrayList<>());
                    } else if (Set.class.isAssignableFrom(type)) {
                        field.set(obj, new HashSet<>());
                    } else if (!type.isPrimitive()) {
                        try {
                            Constructor<?> ctor = type.getDeclaredConstructor();
                            ctor.setAccessible(true);
                            Object novoObjeto = ctor.newInstance();
                            field.set(obj, novoObjeto);
                        } catch (Exception e) {
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Erro ao inicializar campo: " + field.getName(), e);
            }
        }
    }

    public static Boolean temValor(Long valor) {
        return valor != null && valor > 0;
    }

    public static Boolean naoTemValor(Long valor) {
        return !temValor(valor);
    }
}
