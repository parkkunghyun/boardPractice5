package boardPractice5.boardPractice5.service;

import boardPractice5.boardPractice5.domain.User;
import boardPractice5.boardPractice5.dto.AddUserRequest;
import boardPractice5.boardPractice5.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    // 회원 정보 저장

    public Long save(AddUserRequest request) {
        User user =  userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .password(bCryptPasswordEncoder.encode(request.getPassword())).build());
        return user.getId();
    }

}
