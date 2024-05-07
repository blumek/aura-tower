const base = 'http://localhost:8080/v1';

export const environment = {
    metrics: {
        base: `${base}/metrics`
    },

    authentication: {
        signUp: `${base}/authentications/credentials`,
        signIn: `${base}/authentications/tokens`,
        refresh: `${base}/authentications/refreshed-tokens`
    }
}