package br.com.mariolemos.gestao_escolar.security.permission;

import br.com.mariolemos.gestao_escolar.service.implement.PermissionService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.support.AopUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class ResourcePermissionAspect {

    private final PermissionService permissionService;

    @Around("@within(resourcePermission)")
    public Object checkPermission(
            ProceedingJoinPoint joinPoint,
            ResourcePermission resourcePermission) throws Throwable {

        Class<?> targetClass =
                AopUtils.getTargetClass(joinPoint.getTarget());

        ResourcePermission permission =
                targetClass.getAnnotation(ResourcePermission.class);

        // usa permission

        return joinPoint.proceed();
    }

    private String resolvePermission(ProceedingJoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();

        return switch (methodName) {
            case "create" -> "CREATE";
            case "update" -> "UPDATE";
            case "list", "findById" -> "VIEW";
            case "delete" -> "DELETE";
            default -> throw new IllegalArgumentException(
                    "Operação não mapeada para o método: " + methodName
            );
        };
    }
}