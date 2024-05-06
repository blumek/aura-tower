const base = 'http://localhost:8080/v1';

export const environment = {
    metrics: {
        base: `${base}/metrics`
    },

    authentication: {
        signUp: `${base}/authentications/credentials`
    }
}