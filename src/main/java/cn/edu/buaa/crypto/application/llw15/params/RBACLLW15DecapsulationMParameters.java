package cn.edu.buaa.crypto.application.llw15.params;

import org.bouncycastle.crypto.CipherParameters;

import java.util.Arrays;

/**
 * Created by Weiran Liu on 16/5/19.
 */
public class RBACLLW15DecapsulationMParameters implements CipherParameters {
    private RBACLLW15PublicKeyParameters publicKeyParameters;
    private RBACLLW15AccessCredentialMParameters accessCredentialMParameters;
    private String[] roles;
    private String id;
    private String time;
    private RBACLLW15EncapsulationParameters encapsulationParameters;

    public RBACLLW15DecapsulationMParameters(
            CipherParameters publicKeyParameters,
            CipherParameters accessCredentialMParameters,
            String[] roles,
            String id,
            String time,
            CipherParameters encapsulationParameters) {
        this.publicKeyParameters = (RBACLLW15PublicKeyParameters)publicKeyParameters;
        this.accessCredentialMParameters = (RBACLLW15AccessCredentialMParameters)accessCredentialMParameters;
        assert(roles.length == this.publicKeyParameters.getMaxRoleNumber());
        this.roles = Arrays.copyOf(roles, roles.length);
        this.id = new String(id);
        this.time = new String(time);
        this.encapsulationParameters = (RBACLLW15EncapsulationParameters)encapsulationParameters;
    }

    public RBACLLW15PublicKeyParameters getPublicKeyParameters() {
        return this.publicKeyParameters;
    }

    public RBACLLW15AccessCredentialMParameters getSecretKeyParameters() {
        return this.accessCredentialMParameters;
    }

    public RBACLLW15EncapsulationParameters getCiphertextParameters() {
        return this.encapsulationParameters;
    }

    public String[] getRoles() { return Arrays.copyOf(roles, roles.length); }

    public String getRolesAt(int index) { return this.roles[index]; }

    public String getId() { return this.id; }

    public String getTime() { return this.time; }
}