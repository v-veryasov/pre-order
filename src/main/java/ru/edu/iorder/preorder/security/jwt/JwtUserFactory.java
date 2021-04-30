//package ru.edu.iorder.preorder.security.jwt;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import ru.edu.iorder.preorder.model.Role;
//import ru.edu.iorder.preorder.model.User;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public final class JwtUserFactory {
//
//    public JwtUserFactory() {
//    }
//
//    public static JwtUser create(User user) {
//        return new JwtUser(
//                user.getId(),
//                user.getUsername(),
//                user.getFirstName(),
//                user.getLastName(),
//                user.getPassword(),
//                user.getEmail(),
//                true,
//                user.getUpdated(),
//                mapToGrantedAuthorities(new ArrayList<>(user.getRoles())));
//    }
//
//    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
//        return userRoles.stream()
//                .map(role ->
//                        new SimpleGrantedAuthority(role.getName())
//                ).collect(Collectors.toList());
//    }
//}