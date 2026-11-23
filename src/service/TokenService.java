
package service;

import model.DigitalToken;
import utility.IdGenerator;

public class TokenService {

    // Generate a new digital token
    public DigitalToken generateToken(int orderId) {

        int tokenNumber = IdGenerator.getTokenNumber();

        DigitalToken token = new DigitalToken(
            tokenNumber,
            orderId
        );

        return token;
    }

}
