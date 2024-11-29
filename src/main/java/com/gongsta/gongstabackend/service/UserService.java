package com.gongsta.gongstabackend.service;

import com.gongsta.gongstabackend.dto.UserDTO;
import com.gongsta.gongstabackend.model.User;
import com.gongsta.gongstabackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // 회원가입 처리
    public void registerUser(UserDTO userDTO) {
        // 비밀번호 암호화
        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());

        // User 객체 생성
        User user = User.builder()
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .password(encryptedPassword)
                .profileImageUrl(userDTO.getProfileImageUrl())
                .build();

        // 사용자 정보 저장
        userRepository.save(user);
    }
}
