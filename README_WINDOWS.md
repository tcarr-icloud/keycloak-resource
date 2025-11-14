Environment variables as found in my Intellij `Spring-boot` run configuration.

`CORS_ALLOWED-ORIGINS=http://localhost:4200;KEYCLOAK_AUTH-SERVER-URL=http://localhost:8080;KEYCLOAK_REALM=development;SERVER_PORT=8081;SPRING_APPLICATION_NAME=spring-keycloak;SPRING_DATASOURCE_PASSWORD=password;SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/spring-keycloak;SPRING_DATASOURCE_USERNAME=postgres;SPRING_JPA_GENERATE-DDL=true;SPRING_JPA_HIBERNATE_DDL-AUTO=update;SPRING_JPA_SHOW-SQL=true;SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER-URI=http://localhost:8080/realms/development;SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_JWK-SET-URI=http://localhost:8080/realms/development/protocol/openid-connect/certs`

HttpClient `Dev` env
`{
"dev": {
"resourceServerUrl": "http://localhost:8081",
"oauthUrl": "http://localhost:8080",
"realm": "development",
"clientId": "api-client",
"clientSecret": "password",
"clientUsername": "api.user@development.com"
}
}`

Keycloak realm export

This is untested, but one should be able to import the realm-export below creating the "development" realm in keycloak.
Then add a user, api.user@development.com, set password as password and assign the "Client Roles/realm-admin" to user.
That should be all the keycloak immediately required.

`{
  "id": "77c8184b-15c5-415e-8290-1189e963bdcf",
  "realm": "development",
  "notBefore": 0,
  "defaultSignatureAlgorithm": "RS256",
  "revokeRefreshToken": false,
  "refreshTokenMaxReuse": 0,
  "accessTokenLifespan": 300,
  "accessTokenLifespanForImplicitFlow": 900,
  "ssoSessionIdleTimeout": 1800,
  "ssoSessionMaxLifespan": 36000,
  "ssoSessionIdleTimeoutRememberMe": 0,
  "ssoSessionMaxLifespanRememberMe": 0,
  "offlineSessionIdleTimeout": 2592000,
  "offlineSessionMaxLifespanEnabled": false,
  "offlineSessionMaxLifespan": 5184000,
  "clientSessionIdleTimeout": 0,
  "clientSessionMaxLifespan": 0,
  "clientOfflineSessionIdleTimeout": 0,
  "clientOfflineSessionMaxLifespan": 0,
  "accessCodeLifespan": 60,
  "accessCodeLifespanUserAction": 300,
  "accessCodeLifespanLogin": 1800,
  "actionTokenGeneratedByAdminLifespan": 43200,
  "actionTokenGeneratedByUserLifespan": 300,
  "oauth2DeviceCodeLifespan": 600,
  "oauth2DevicePollingInterval": 5,
  "enabled": true,
  "sslRequired": "external",
  "registrationAllowed": false,
  "registrationEmailAsUsername": false,
  "rememberMe": false,
  "verifyEmail": false,
  "loginWithEmailAllowed": true,
  "duplicateEmailsAllowed": false,
  "resetPasswordAllowed": false,
  "editUsernameAllowed": false,
  "bruteForceProtected": false,
  "permanentLockout": false,
  "maxTemporaryLockouts": 0,
  "bruteForceStrategy": "MULTIPLE",
  "maxFailureWaitSeconds": 900,
  "minimumQuickLoginWaitSeconds": 60,
  "waitIncrementSeconds": 60,
  "quickLoginCheckMilliSeconds": 1000,
  "maxDeltaTimeSeconds": 43200,
  "failureFactor": 30,
  "roles": {
    "realm": [
      {
        "id": "06608585-9c7e-44b0-8bf4-580ba12422d1",
        "name": "offline_access",
        "description": "${role_offline-access}",
        "composite": false,
        "clientRole": false,
        "containerId": "77c8184b-15c5-415e-8290-1189e963bdcf",
        "attributes": {}
      },
      {
        "id": "04cbd70f-25e8-4a77-a51e-650e20c0e006",
        "name": "uma_authorization",
        "description": "${role_uma_authorization}",
        "composite": false,
        "clientRole": false,
        "containerId": "77c8184b-15c5-415e-8290-1189e963bdcf",
        "attributes": {}
      },
      {
        "id": "8ac75815-a290-4147-87bf-bb37bcb4bda3",
        "name": "default-roles-development",
        "description": "${role_default-roles}",
        "composite": true,
        "composites": {
          "realm": [
            "offline_access",
            "uma_authorization"
          ],
          "client": {
            "account": [
              "view-profile",
              "manage-account"
            ]
          }
        },
        "clientRole": false,
        "containerId": "77c8184b-15c5-415e-8290-1189e963bdcf",
        "attributes": {}
      }
    ],
    "client": {
      "realm-management": [
        {
          "id": "0feeac7f-f0d9-45e9-8319-417b4ba643bd",
          "name": "view-events",
          "description": "${role_view-events}",
          "composite": false,
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "f861e62d-713b-461d-a0af-3a9bb1c7a265",
          "name": "query-realms",
          "description": "${role_query-realms}",
          "composite": false,
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "fd39ff1a-5585-45e4-8cba-b89cf0e1e118",
          "name": "query-clients",
          "description": "${role_query-clients}",
          "composite": false,
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "79b4b727-9e1f-4edd-8e5b-7ee76bba352a",
          "name": "query-users",
          "description": "${role_query-users}",
          "composite": false,
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "da472aec-b3d6-458e-bda9-9b58c4b44186",
          "name": "manage-authorization",
          "description": "${role_manage-authorization}",
          "composite": false,
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "25b3ebcc-a860-432e-bcff-f28875b02f4c",
          "name": "query-groups",
          "description": "${role_query-groups}",
          "composite": false,
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "bdcf3a75-a655-4030-b566-03f1135e5d1b",
          "name": "view-users",
          "description": "${role_view-users}",
          "composite": true,
          "composites": {
            "client": {
              "realm-management": [
                "query-groups",
                "query-users"
              ]
            }
          },
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "4a3f670a-23a9-4737-b3d2-bcbb9ffa3453",
          "name": "create-client",
          "description": "${role_create-client}",
          "composite": false,
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "d845219a-1713-4f94-8fd5-ea81c79e9d5b",
          "name": "view-clients",
          "description": "${role_view-clients}",
          "composite": true,
          "composites": {
            "client": {
              "realm-management": [
                "query-clients"
              ]
            }
          },
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "8cfc219b-0fe3-42d9-871c-1ea90223915b",
          "name": "manage-realm",
          "description": "${role_manage-realm}",
          "composite": false,
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "740872ee-7cc2-4f68-b7a1-3afe268e8354",
          "name": "manage-events",
          "description": "${role_manage-events}",
          "composite": false,
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "ac5f3ea2-af19-4a0d-8dbf-5e14e8541cd1",
          "name": "view-identity-providers",
          "description": "${role_view-identity-providers}",
          "composite": false,
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "5ab9e01e-392b-4257-931f-f23804060720",
          "name": "manage-users",
          "description": "${role_manage-users}",
          "composite": false,
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "ed67c75c-6f39-4ddf-a972-b1f70380fe5f",
          "name": "realm-admin",
          "description": "${role_realm-admin}",
          "composite": true,
          "composites": {
            "client": {
              "realm-management": [
                "view-events",
                "query-realms",
                "query-users",
                "query-clients",
                "view-users",
                "manage-authorization",
                "query-groups",
                "create-client",
                "view-clients",
                "manage-realm",
                "view-identity-providers",
                "manage-events",
                "manage-users",
                "view-realm",
                "impersonation",
                "manage-clients",
                "view-authorization",
                "manage-identity-providers"
              ]
            }
          },
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "4e36e322-fab6-4557-bb85-00aa51765028",
          "name": "impersonation",
          "description": "${role_impersonation}",
          "composite": false,
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "ea9c003b-4bc8-49c7-9d9c-270355b4a528",
          "name": "view-realm",
          "description": "${role_view-realm}",
          "composite": false,
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "6e29eed0-7381-4f00-a422-b0ce8793d35f",
          "name": "manage-clients",
          "description": "${role_manage-clients}",
          "composite": false,
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "33631aff-a724-4b48-b752-6885f363fd07",
          "name": "view-authorization",
          "description": "${role_view-authorization}",
          "composite": false,
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        },
        {
          "id": "797488c5-ab66-4f65-b4d3-9e4e75578b42",
          "name": "manage-identity-providers",
          "description": "${role_manage-identity-providers}",
          "composite": false,
          "clientRole": true,
          "containerId": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
          "attributes": {}
        }
      ],
      "api-client": [
        {
          "id": "acb34638-faad-44dc-8411-d214738771b9",
          "name": "admin",
          "description": "",
          "composite": false,
          "clientRole": true,
          "containerId": "6246256b-88e9-439d-b356-50017b40401f",
          "attributes": {}
        }
      ],
      "security-admin-console": [],
      "admin-cli": [],
      "account-console": [],
      "broker": [
        {
          "id": "0ea06cf7-bd1f-4f8f-bb80-f0a567081c29",
          "name": "read-token",
          "description": "${role_read-token}",
          "composite": false,
          "clientRole": true,
          "containerId": "8dd45749-9722-40f1-8ee5-5446856ccd44",
          "attributes": {}
        }
      ],
      "account": [
        {
          "id": "e05943c2-9147-4b03-b1ed-efcacdee2681",
          "name": "delete-account",
          "description": "${role_delete-account}",
          "composite": false,
          "clientRole": true,
          "containerId": "a905a60c-587d-42b4-9987-ed1a5ffe4c84",
          "attributes": {}
        },
        {
          "id": "69f30bfc-4682-4db8-99b5-8709830c7d6d",
          "name": "view-profile",
          "description": "${role_view-profile}",
          "composite": false,
          "clientRole": true,
          "containerId": "a905a60c-587d-42b4-9987-ed1a5ffe4c84",
          "attributes": {}
        },
        {
          "id": "ef7d4b5e-f08b-4a9b-a099-db6ebe829cf3",
          "name": "view-consent",
          "description": "${role_view-consent}",
          "composite": false,
          "clientRole": true,
          "containerId": "a905a60c-587d-42b4-9987-ed1a5ffe4c84",
          "attributes": {}
        },
        {
          "id": "4ca2a3f6-ca21-40d7-8529-9bf81a2f8d71",
          "name": "view-groups",
          "description": "${role_view-groups}",
          "composite": false,
          "clientRole": true,
          "containerId": "a905a60c-587d-42b4-9987-ed1a5ffe4c84",
          "attributes": {}
        },
        {
          "id": "755d4447-20c6-4198-b6a9-dbce6547193f",
          "name": "manage-account",
          "description": "${role_manage-account}",
          "composite": true,
          "composites": {
            "client": {
              "account": [
                "manage-account-links"
              ]
            }
          },
          "clientRole": true,
          "containerId": "a905a60c-587d-42b4-9987-ed1a5ffe4c84",
          "attributes": {}
        },
        {
          "id": "2d980d87-5ec8-4d00-9858-b587d1fecd7f",
          "name": "manage-account-links",
          "description": "${role_manage-account-links}",
          "composite": false,
          "clientRole": true,
          "containerId": "a905a60c-587d-42b4-9987-ed1a5ffe4c84",
          "attributes": {}
        },
        {
          "id": "cbdeb2e2-919e-4105-86ac-148c955754ac",
          "name": "manage-consent",
          "description": "${role_manage-consent}",
          "composite": true,
          "composites": {
            "client": {
              "account": [
                "view-consent"
              ]
            }
          },
          "clientRole": true,
          "containerId": "a905a60c-587d-42b4-9987-ed1a5ffe4c84",
          "attributes": {}
        },
        {
          "id": "bb02885b-2497-4145-ac87-821c4ed6d6cd",
          "name": "view-applications",
          "description": "${role_view-applications}",
          "composite": false,
          "clientRole": true,
          "containerId": "a905a60c-587d-42b4-9987-ed1a5ffe4c84",
          "attributes": {}
        }
      ]
    }
  },
  "groups": [],
  "defaultRole": {
    "id": "8ac75815-a290-4147-87bf-bb37bcb4bda3",
    "name": "default-roles-development",
    "description": "${role_default-roles}",
    "composite": true,
    "clientRole": false,
    "containerId": "77c8184b-15c5-415e-8290-1189e963bdcf"
  },
  "requiredCredentials": [
    "password"
  ],
  "otpPolicyType": "totp",
  "otpPolicyAlgorithm": "HmacSHA1",
  "otpPolicyInitialCounter": 0,
  "otpPolicyDigits": 6,
  "otpPolicyLookAheadWindow": 1,
  "otpPolicyPeriod": 30,
  "otpPolicyCodeReusable": false,
  "otpSupportedApplications": [
    "totpAppFreeOTPName",
    "totpAppGoogleName",
    "totpAppMicrosoftAuthenticatorName"
  ],
  "localizationTexts": {},
  "webAuthnPolicyRpEntityName": "keycloak",
  "webAuthnPolicySignatureAlgorithms": [
    "ES256",
    "RS256"
  ],
  "webAuthnPolicyRpId": "",
  "webAuthnPolicyAttestationConveyancePreference": "not specified",
  "webAuthnPolicyAuthenticatorAttachment": "not specified",
  "webAuthnPolicyRequireResidentKey": "not specified",
  "webAuthnPolicyUserVerificationRequirement": "not specified",
  "webAuthnPolicyCreateTimeout": 0,
  "webAuthnPolicyAvoidSameAuthenticatorRegister": false,
  "webAuthnPolicyAcceptableAaguids": [],
  "webAuthnPolicyExtraOrigins": [],
  "webAuthnPolicyPasswordlessRpEntityName": "keycloak",
  "webAuthnPolicyPasswordlessSignatureAlgorithms": [
    "ES256",
    "RS256"
  ],
  "webAuthnPolicyPasswordlessRpId": "",
  "webAuthnPolicyPasswordlessAttestationConveyancePreference": "not specified",
  "webAuthnPolicyPasswordlessAuthenticatorAttachment": "not specified",
  "webAuthnPolicyPasswordlessRequireResidentKey": "Yes",
  "webAuthnPolicyPasswordlessUserVerificationRequirement": "required",
  "webAuthnPolicyPasswordlessCreateTimeout": 0,
  "webAuthnPolicyPasswordlessAvoidSameAuthenticatorRegister": false,
  "webAuthnPolicyPasswordlessAcceptableAaguids": [],
  "webAuthnPolicyPasswordlessExtraOrigins": [],
  "scopeMappings": [
    {
      "clientScope": "offline_access",
      "roles": [
        "offline_access"
      ]
    }
  ],
  "clientScopeMappings": {
    "account": [
      {
        "client": "account-console",
        "roles": [
          "manage-account",
          "view-groups"
        ]
      }
    ]
  },
  "clients": [
    {
      "id": "a905a60c-587d-42b4-9987-ed1a5ffe4c84",
      "clientId": "account",
      "name": "${client_account}",
      "rootUrl": "${authBaseUrl}",
      "baseUrl": "/realms/development/account/",
      "surrogateAuthRequired": false,
      "enabled": true,
      "alwaysDisplayInConsole": false,
      "clientAuthenticatorType": "client-secret",
      "redirectUris": [
        "/realms/development/account/*"
      ],
      "webOrigins": [],
      "notBefore": 0,
      "bearerOnly": false,
      "consentRequired": false,
      "standardFlowEnabled": true,
      "implicitFlowEnabled": false,
      "directAccessGrantsEnabled": false,
      "serviceAccountsEnabled": false,
      "publicClient": true,
      "frontchannelLogout": false,
      "protocol": "openid-connect",
      "attributes": {
        "realm_client": "false",
        "post.logout.redirect.uris": "+"
      },
      "authenticationFlowBindingOverrides": {},
      "fullScopeAllowed": false,
      "nodeReRegistrationTimeout": 0,
      "defaultClientScopes": [
        "web-origins",
        "acr",
        "profile",
        "roles",
        "basic",
        "email"
      ],
      "optionalClientScopes": [
        "address",
        "phone",
        "offline_access",
        "organization",
        "microprofile-jwt"
      ]
    },
    {
      "id": "20d970af-d729-45f6-83fa-29ae6d65e1cc",
      "clientId": "account-console",
      "name": "${client_account-console}",
      "rootUrl": "${authBaseUrl}",
      "baseUrl": "/realms/development/account/",
      "surrogateAuthRequired": false,
      "enabled": true,
      "alwaysDisplayInConsole": false,
      "clientAuthenticatorType": "client-secret",
      "redirectUris": [
        "/realms/development/account/*"
      ],
      "webOrigins": [],
      "notBefore": 0,
      "bearerOnly": false,
      "consentRequired": false,
      "standardFlowEnabled": true,
      "implicitFlowEnabled": false,
      "directAccessGrantsEnabled": false,
      "serviceAccountsEnabled": false,
      "publicClient": true,
      "frontchannelLogout": false,
      "protocol": "openid-connect",
      "attributes": {
        "realm_client": "false",
        "post.logout.redirect.uris": "+",
        "pkce.code.challenge.method": "S256"
      },
      "authenticationFlowBindingOverrides": {},
      "fullScopeAllowed": false,
      "nodeReRegistrationTimeout": 0,
      "protocolMappers": [
        {
          "id": "c9fc8c86-87e1-413d-9960-8db688341d01",
          "name": "audience resolve",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-audience-resolve-mapper",
          "consentRequired": false,
          "config": {}
        }
      ],
      "defaultClientScopes": [
        "web-origins",
        "acr",
        "profile",
        "roles",
        "basic",
        "email"
      ],
      "optionalClientScopes": [
        "address",
        "phone",
        "offline_access",
        "organization",
        "microprofile-jwt"
      ]
    },
    {
      "id": "0ffb4283-d0b2-42cb-b157-1e63ed804d27",
      "clientId": "admin-cli",
      "name": "${client_admin-cli}",
      "surrogateAuthRequired": false,
      "enabled": true,
      "alwaysDisplayInConsole": false,
      "clientAuthenticatorType": "client-secret",
      "redirectUris": [],
      "webOrigins": [],
      "notBefore": 0,
      "bearerOnly": false,
      "consentRequired": false,
      "standardFlowEnabled": false,
      "implicitFlowEnabled": false,
      "directAccessGrantsEnabled": true,
      "serviceAccountsEnabled": false,
      "publicClient": true,
      "frontchannelLogout": false,
      "protocol": "openid-connect",
      "attributes": {
        "realm_client": "false",
        "client.use.lightweight.access.token.enabled": "true"
      },
      "authenticationFlowBindingOverrides": {},
      "fullScopeAllowed": true,
      "nodeReRegistrationTimeout": 0,
      "defaultClientScopes": [
        "web-origins",
        "acr",
        "profile",
        "roles",
        "basic",
        "email"
      ],
      "optionalClientScopes": [
        "address",
        "phone",
        "offline_access",
        "organization",
        "microprofile-jwt"
      ]
    },
    {
      "id": "6246256b-88e9-439d-b356-50017b40401f",
      "clientId": "api-client",
      "name": "api client ",
      "description": "",
      "rootUrl": "",
      "adminUrl": "",
      "baseUrl": "",
      "surrogateAuthRequired": false,
      "enabled": true,
      "alwaysDisplayInConsole": false,
      "clientAuthenticatorType": "client-secret",
      "redirectUris": [
        "/*"
      ],
      "webOrigins": [
        "/*"
      ],
      "notBefore": 0,
      "bearerOnly": false,
      "consentRequired": false,
      "standardFlowEnabled": true,
      "implicitFlowEnabled": false,
      "directAccessGrantsEnabled": true,
      "serviceAccountsEnabled": false,
      "publicClient": true,
      "frontchannelLogout": true,
      "protocol": "openid-connect",
      "attributes": {
        "realm_client": "false",
        "oidc.ciba.grant.enabled": "false",
        "backchannel.logout.session.required": "true",
        "standard.token.exchange.enabled": "false",
        "frontchannel.logout.session.required": "true",
        "display.on.consent.screen": "false",
        "oauth2.device.authorization.grant.enabled": "false",
        "backchannel.logout.revoke.offline.tokens": "false",
        "dpop.bound.access.tokens": "false"
      },
      "authenticationFlowBindingOverrides": {},
      "fullScopeAllowed": true,
      "nodeReRegistrationTimeout": -1,
      "defaultClientScopes": [
        "web-origins",
        "acr",
        "profile",
        "roles",
        "basic",
        "email"
      ],
      "optionalClientScopes": [
        "address",
        "phone",
        "offline_access",
        "organization",
        "microprofile-jwt"
      ]
    },
    {
      "id": "8dd45749-9722-40f1-8ee5-5446856ccd44",
      "clientId": "broker",
      "name": "${client_broker}",
      "surrogateAuthRequired": false,
      "enabled": true,
      "alwaysDisplayInConsole": false,
      "clientAuthenticatorType": "client-secret",
      "redirectUris": [],
      "webOrigins": [],
      "notBefore": 0,
      "bearerOnly": true,
      "consentRequired": false,
      "standardFlowEnabled": true,
      "implicitFlowEnabled": false,
      "directAccessGrantsEnabled": false,
      "serviceAccountsEnabled": false,
      "publicClient": false,
      "frontchannelLogout": false,
      "protocol": "openid-connect",
      "attributes": {
        "realm_client": "true"
      },
      "authenticationFlowBindingOverrides": {},
      "fullScopeAllowed": false,
      "nodeReRegistrationTimeout": 0,
      "defaultClientScopes": [
        "web-origins",
        "acr",
        "profile",
        "roles",
        "basic",
        "email"
      ],
      "optionalClientScopes": [
        "address",
        "phone",
        "offline_access",
        "organization",
        "microprofile-jwt"
      ]
    },
    {
      "id": "cb84b808-6af2-480e-bb3a-9143de2b8bbd",
      "clientId": "realm-management",
      "name": "${client_realm-management}",
      "surrogateAuthRequired": false,
      "enabled": true,
      "alwaysDisplayInConsole": false,
      "clientAuthenticatorType": "client-secret",
      "redirectUris": [],
      "webOrigins": [],
      "notBefore": 0,
      "bearerOnly": true,
      "consentRequired": false,
      "standardFlowEnabled": true,
      "implicitFlowEnabled": false,
      "directAccessGrantsEnabled": false,
      "serviceAccountsEnabled": false,
      "publicClient": false,
      "frontchannelLogout": false,
      "protocol": "openid-connect",
      "attributes": {
        "realm_client": "true"
      },
      "authenticationFlowBindingOverrides": {},
      "fullScopeAllowed": false,
      "nodeReRegistrationTimeout": 0,
      "defaultClientScopes": [
        "web-origins",
        "acr",
        "profile",
        "roles",
        "basic",
        "email"
      ],
      "optionalClientScopes": [
        "address",
        "phone",
        "offline_access",
        "organization",
        "microprofile-jwt"
      ]
    },
    {
      "id": "54e35f59-4852-44fb-8178-25528c33f35c",
      "clientId": "security-admin-console",
      "name": "${client_security-admin-console}",
      "rootUrl": "${authAdminUrl}",
      "baseUrl": "/admin/development/console/",
      "surrogateAuthRequired": false,
      "enabled": true,
      "alwaysDisplayInConsole": false,
      "clientAuthenticatorType": "client-secret",
      "redirectUris": [
        "/admin/development/console/*"
      ],
      "webOrigins": [
        "+"
      ],
      "notBefore": 0,
      "bearerOnly": false,
      "consentRequired": false,
      "standardFlowEnabled": true,
      "implicitFlowEnabled": false,
      "directAccessGrantsEnabled": false,
      "serviceAccountsEnabled": false,
      "publicClient": true,
      "frontchannelLogout": false,
      "protocol": "openid-connect",
      "attributes": {
        "realm_client": "false",
        "client.use.lightweight.access.token.enabled": "true",
        "post.logout.redirect.uris": "+",
        "pkce.code.challenge.method": "S256"
      },
      "authenticationFlowBindingOverrides": {},
      "fullScopeAllowed": true,
      "nodeReRegistrationTimeout": 0,
      "protocolMappers": [
        {
          "id": "5b5926a8-53a8-4a46-a2de-44099ff3f46f",
          "name": "locale",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "locale",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "locale",
            "jsonType.label": "String"
          }
        }
      ],
      "defaultClientScopes": [
        "web-origins",
        "acr",
        "profile",
        "roles",
        "basic",
        "email"
      ],
      "optionalClientScopes": [
        "address",
        "phone",
        "offline_access",
        "organization",
        "microprofile-jwt"
      ]
    }
  ],
  "clientScopes": [
    {
      "id": "41b40e51-3c99-4ddc-b046-f325e8c00007",
      "name": "basic",
      "description": "OpenID Connect scope for add all basic claims to the token",
      "protocol": "openid-connect",
      "attributes": {
        "include.in.token.scope": "false",
        "display.on.consent.screen": "false"
      },
      "protocolMappers": [
        {
          "id": "6421d665-1947-4975-827e-6136821063b9",
          "name": "auth_time",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usersessionmodel-note-mapper",
          "consentRequired": false,
          "config": {
            "user.session.note": "AUTH_TIME",
            "id.token.claim": "true",
            "introspection.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "auth_time",
            "jsonType.label": "long"
          }
        },
        {
          "id": "609eb3e3-b4d5-493a-8a30-e67e0ed36e33",
          "name": "sub",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-sub-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "access.token.claim": "true"
          }
        }
      ]
    },
    {
      "id": "bbe7bc74-50e3-4562-b414-c5a0eea711ba",
      "name": "role_list",
      "description": "SAML role list",
      "protocol": "saml",
      "attributes": {
        "consent.screen.text": "${samlRoleListScopeConsentText}",
        "display.on.consent.screen": "true"
      },
      "protocolMappers": [
        {
          "id": "8aa7dd17-1521-4c19-ac75-7252584827bd",
          "name": "role list",
          "protocol": "saml",
          "protocolMapper": "saml-role-list-mapper",
          "consentRequired": false,
          "config": {
            "single": "false",
            "attribute.nameformat": "Basic",
            "attribute.name": "Role"
          }
        }
      ]
    },
    {
      "id": "e7a1f833-18d1-4afc-872f-817a4a1a0535",
      "name": "profile",
      "description": "OpenID Connect built-in scope: profile",
      "protocol": "openid-connect",
      "attributes": {
        "include.in.token.scope": "true",
        "consent.screen.text": "${profileScopeConsentText}",
        "display.on.consent.screen": "true"
      },
      "protocolMappers": [
        {
          "id": "f88a015a-e6fa-4e1a-9f90-82c9e2833465",
          "name": "family name",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "lastName",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "family_name",
            "jsonType.label": "String"
          }
        },
        {
          "id": "902ef4fc-ef6f-418a-b440-c9e539fbc942",
          "name": "picture",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "picture",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "picture",
            "jsonType.label": "String"
          }
        },
        {
          "id": "26f45af3-63f4-4593-bc82-cbdbce36178f",
          "name": "profile",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "profile",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "profile",
            "jsonType.label": "String"
          }
        },
        {
          "id": "95e61833-a824-4a4c-af7a-aeef394131e1",
          "name": "locale",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "locale",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "locale",
            "jsonType.label": "String"
          }
        },
        {
          "id": "c5bf119b-588d-4d67-afec-716e22d12c22",
          "name": "middle name",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "middleName",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "middle_name",
            "jsonType.label": "String"
          }
        },
        {
          "id": "d354ece0-d8a8-4645-b92b-6aa9eca909b0",
          "name": "website",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "website",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "website",
            "jsonType.label": "String"
          }
        },
        {
          "id": "34c2d92a-c938-4af6-94c5-cfb8e83287f6",
          "name": "given name",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "firstName",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "given_name",
            "jsonType.label": "String"
          }
        },
        {
          "id": "c8662330-e61d-4f25-87f7-9da13352f67b",
          "name": "updated at",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "updatedAt",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "updated_at",
            "jsonType.label": "long"
          }
        },
        {
          "id": "01306579-842e-42ce-ae01-417273ecefc6",
          "name": "full name",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-full-name-mapper",
          "consentRequired": false,
          "config": {
            "id.token.claim": "true",
            "introspection.token.claim": "true",
            "access.token.claim": "true",
            "userinfo.token.claim": "true"
          }
        },
        {
          "id": "3b9873b6-e095-48e7-834c-75480e7f720e",
          "name": "username",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "username",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "preferred_username",
            "jsonType.label": "String"
          }
        },
        {
          "id": "617e286c-27fc-4e97-be49-b20fcfb6d7d0",
          "name": "gender",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "gender",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "gender",
            "jsonType.label": "String"
          }
        },
        {
          "id": "4937a065-a859-4e54-a1c0-d308c3f4a904",
          "name": "birthdate",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "birthdate",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "birthdate",
            "jsonType.label": "String"
          }
        },
        {
          "id": "e3c25b37-a937-4213-aa05-22d4a50dcd46",
          "name": "nickname",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "nickname",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "nickname",
            "jsonType.label": "String"
          }
        },
        {
          "id": "e8d8df3e-dce9-4164-9daa-5b9422fa1111",
          "name": "zoneinfo",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "zoneinfo",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "zoneinfo",
            "jsonType.label": "String"
          }
        }
      ]
    },
    {
      "id": "ced89dfe-7485-48c3-9986-b779b02c555f",
      "name": "microprofile-jwt",
      "description": "Microprofile - JWT built-in scope",
      "protocol": "openid-connect",
      "attributes": {
        "include.in.token.scope": "true",
        "display.on.consent.screen": "false"
      },
      "protocolMappers": [
        {
          "id": "d0cc46fc-817c-4b41-87f5-28bdd882803e",
          "name": "upn",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "username",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "upn",
            "jsonType.label": "String"
          }
        },
        {
          "id": "0dc88a73-6599-47fd-a611-a6132293a824",
          "name": "groups",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-realm-role-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "multivalued": "true",
            "user.attribute": "foo",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "groups",
            "jsonType.label": "String"
          }
        }
      ]
    },
    {
      "id": "e90d1cb1-ce67-4127-a030-14868213b7ec",
      "name": "service_account",
      "description": "Specific scope for a client enabled for service accounts",
      "protocol": "openid-connect",
      "attributes": {
        "include.in.token.scope": "false",
        "display.on.consent.screen": "false"
      },
      "protocolMappers": [
        {
          "id": "19ab639e-76da-4754-8cc4-19af160f6d8b",
          "name": "Client IP Address",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usersessionmodel-note-mapper",
          "consentRequired": false,
          "config": {
            "user.session.note": "clientAddress",
            "id.token.claim": "true",
            "introspection.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "clientAddress",
            "jsonType.label": "String"
          }
        },
        {
          "id": "1bc53bfe-658f-420b-8e9c-08af108c44ba",
          "name": "Client ID",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usersessionmodel-note-mapper",
          "consentRequired": false,
          "config": {
            "user.session.note": "client_id",
            "id.token.claim": "true",
            "introspection.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "client_id",
            "jsonType.label": "String"
          }
        },
        {
          "id": "61edfd78-3063-4b55-8a56-d5a04c79389d",
          "name": "Client Host",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usersessionmodel-note-mapper",
          "consentRequired": false,
          "config": {
            "user.session.note": "clientHost",
            "id.token.claim": "true",
            "introspection.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "clientHost",
            "jsonType.label": "String"
          }
        }
      ]
    },
    {
      "id": "b8a4c412-6d67-4513-a5b0-091bc38b417e",
      "name": "address",
      "description": "OpenID Connect built-in scope: address",
      "protocol": "openid-connect",
      "attributes": {
        "include.in.token.scope": "true",
        "consent.screen.text": "${addressScopeConsentText}",
        "display.on.consent.screen": "true"
      },
      "protocolMappers": [
        {
          "id": "a29a4edc-cec0-4e00-b9cb-4f3660e6a4a2",
          "name": "address",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-address-mapper",
          "consentRequired": false,
          "config": {
            "user.attribute.formatted": "formatted",
            "user.attribute.country": "country",
            "introspection.token.claim": "true",
            "user.attribute.postal_code": "postal_code",
            "userinfo.token.claim": "true",
            "user.attribute.street": "street",
            "id.token.claim": "true",
            "user.attribute.region": "region",
            "access.token.claim": "true",
            "user.attribute.locality": "locality"
          }
        }
      ]
    },
    {
      "id": "14d963cf-4abf-4a42-8098-ce66cd61132b",
      "name": "offline_access",
      "description": "OpenID Connect built-in scope: offline_access",
      "protocol": "openid-connect",
      "attributes": {
        "consent.screen.text": "${offlineAccessScopeConsentText}",
        "display.on.consent.screen": "true"
      }
    },
    {
      "id": "c5d943d3-9d02-4ce0-b4fe-10da732c4442",
      "name": "web-origins",
      "description": "OpenID Connect scope for add allowed web origins to the access token",
      "protocol": "openid-connect",
      "attributes": {
        "include.in.token.scope": "false",
        "consent.screen.text": "",
        "display.on.consent.screen": "false"
      },
      "protocolMappers": [
        {
          "id": "ed34b728-32d8-420f-bf3a-9e17b55f3045",
          "name": "allowed web origins",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-allowed-origins-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "access.token.claim": "true"
          }
        }
      ]
    },
    {
      "id": "2d0d2f5a-9117-494a-a523-2f340cefc93c",
      "name": "saml_organization",
      "description": "Organization Membership",
      "protocol": "saml",
      "attributes": {
        "display.on.consent.screen": "false"
      },
      "protocolMappers": [
        {
          "id": "c0c88218-2b28-4f5b-affc-33e23c721526",
          "name": "organization",
          "protocol": "saml",
          "protocolMapper": "saml-organization-membership-mapper",
          "consentRequired": false,
          "config": {}
        }
      ]
    },
    {
      "id": "4478d679-1cad-48c7-8be7-b10cc0fabe87",
      "name": "phone",
      "description": "OpenID Connect built-in scope: phone",
      "protocol": "openid-connect",
      "attributes": {
        "include.in.token.scope": "true",
        "consent.screen.text": "${phoneScopeConsentText}",
        "display.on.consent.screen": "true"
      },
      "protocolMappers": [
        {
          "id": "04ae23e9-0677-4155-8ab7-826fe83bd891",
          "name": "phone number verified",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "phoneNumberVerified",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "phone_number_verified",
            "jsonType.label": "boolean"
          }
        },
        {
          "id": "f980c199-3670-4ed6-8527-e38a58a1aa57",
          "name": "phone number",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "phoneNumber",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "phone_number",
            "jsonType.label": "String"
          }
        }
      ]
    },
    {
      "id": "b84c58cb-65a5-4b85-b9c8-0a7d1654c8b3",
      "name": "acr",
      "description": "OpenID Connect scope for add acr (authentication context class reference) to the token",
      "protocol": "openid-connect",
      "attributes": {
        "include.in.token.scope": "false",
        "display.on.consent.screen": "false"
      },
      "protocolMappers": [
        {
          "id": "1ed42d61-6b7c-4c3c-ae9a-428a171dbe11",
          "name": "acr loa level",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-acr-mapper",
          "consentRequired": false,
          "config": {
            "id.token.claim": "true",
            "introspection.token.claim": "true",
            "access.token.claim": "true"
          }
        }
      ]
    },
    {
      "id": "e350ea3a-da27-4299-965b-f5d125515f41",
      "name": "email",
      "description": "OpenID Connect built-in scope: email",
      "protocol": "openid-connect",
      "attributes": {
        "include.in.token.scope": "true",
        "consent.screen.text": "${emailScopeConsentText}",
        "display.on.consent.screen": "true"
      },
      "protocolMappers": [
        {
          "id": "a1e9c7dd-39db-4343-b98d-3d72c6684d92",
          "name": "email verified",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-property-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "emailVerified",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "email_verified",
            "jsonType.label": "boolean"
          }
        },
        {
          "id": "ddb80d3d-08c4-4c71-aa77-bec82c225eab",
          "name": "email",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-attribute-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "userinfo.token.claim": "true",
            "user.attribute": "email",
            "id.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "email",
            "jsonType.label": "String"
          }
        }
      ]
    },
    {
      "id": "da3fd745-f78c-4d33-8ad8-5b5c06d1ad04",
      "name": "roles",
      "description": "OpenID Connect scope for add user roles to the access token",
      "protocol": "openid-connect",
      "attributes": {
        "include.in.token.scope": "false",
        "consent.screen.text": "${rolesScopeConsentText}",
        "display.on.consent.screen": "true"
      },
      "protocolMappers": [
        {
          "id": "2067ef43-bc40-489a-aa00-50e28363ca24",
          "name": "realm roles",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-realm-role-mapper",
          "consentRequired": false,
          "config": {
            "user.attribute": "foo",
            "introspection.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "realm_access.roles",
            "jsonType.label": "String",
            "multivalued": "true"
          }
        },
        {
          "id": "a430d62f-24ee-4393-8caa-f314e2c437d1",
          "name": "client roles",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-usermodel-client-role-mapper",
          "consentRequired": false,
          "config": {
            "user.attribute": "foo",
            "introspection.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "resource_access.${client_id}.roles",
            "jsonType.label": "String",
            "multivalued": "true"
          }
        },
        {
          "id": "5da139ba-1e20-4c27-ac56-e294dea32ab0",
          "name": "audience resolve",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-audience-resolve-mapper",
          "consentRequired": false,
          "config": {
            "introspection.token.claim": "true",
            "access.token.claim": "true"
          }
        }
      ]
    },
    {
      "id": "34fecfa3-f284-4dac-a66f-79a682c6a5b6",
      "name": "organization",
      "description": "Additional claims about the organization a subject belongs to",
      "protocol": "openid-connect",
      "attributes": {
        "include.in.token.scope": "true",
        "consent.screen.text": "${organizationScopeConsentText}",
        "display.on.consent.screen": "true"
      },
      "protocolMappers": [
        {
          "id": "400bfe09-cb53-4e52-a30f-fbc0cfb6ee4b",
          "name": "organization",
          "protocol": "openid-connect",
          "protocolMapper": "oidc-organization-membership-mapper",
          "consentRequired": false,
          "config": {
            "id.token.claim": "true",
            "introspection.token.claim": "true",
            "access.token.claim": "true",
            "claim.name": "organization",
            "jsonType.label": "String",
            "multivalued": "true"
          }
        }
      ]
    }
  ],
  "defaultDefaultClientScopes": [
    "role_list",
    "saml_organization",
    "profile",
    "email",
    "roles",
    "web-origins",
    "acr",
    "basic"
  ],
  "defaultOptionalClientScopes": [
    "offline_access",
    "address",
    "phone",
    "microprofile-jwt",
    "organization"
  ],
  "browserSecurityHeaders": {
    "contentSecurityPolicyReportOnly": "",
    "xContentTypeOptions": "nosniff",
    "referrerPolicy": "no-referrer",
    "xRobotsTag": "none",
    "xFrameOptions": "SAMEORIGIN",
    "contentSecurityPolicy": "frame-src 'self'; frame-ancestors 'self'; object-src 'none';",
    "strictTransportSecurity": "max-age=31536000; includeSubDomains"
  },
  "smtpServer": {},
  "eventsEnabled": false,
  "eventsListeners": [
    "jboss-logging"
  ],
  "enabledEventTypes": [],
  "adminEventsEnabled": false,
  "adminEventsDetailsEnabled": false,
  "identityProviders": [],
  "identityProviderMappers": [],
  "components": {
    "org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy": [
      {
        "id": "30cecb5b-a34a-48a2-b056-331ecc273421",
        "name": "Max Clients Limit",
        "providerId": "max-clients",
        "subType": "anonymous",
        "subComponents": {},
        "config": {
          "max-clients": [
            "200"
          ]
        }
      },
      {
        "id": "71ea38d7-58bf-40e9-9cda-474a91545ca9",
        "name": "Allowed Protocol Mapper Types",
        "providerId": "allowed-protocol-mappers",
        "subType": "anonymous",
        "subComponents": {},
        "config": {
          "allowed-protocol-mapper-types": [
            "saml-user-attribute-mapper",
            "oidc-full-name-mapper",
            "oidc-address-mapper",
            "oidc-usermodel-attribute-mapper",
            "oidc-sha256-pairwise-sub-mapper",
            "oidc-usermodel-property-mapper",
            "saml-user-property-mapper",
            "saml-role-list-mapper"
          ]
        }
      },
      {
        "id": "a43e90d3-cf6e-41f5-8166-38f6b39e51d8",
        "name": "Consent Required",
        "providerId": "consent-required",
        "subType": "anonymous",
        "subComponents": {},
        "config": {}
      },
      {
        "id": "7ac14ef0-ed4f-42a2-9ee8-5a9792c9ea72",
        "name": "Allowed Client Scopes",
        "providerId": "allowed-client-templates",
        "subType": "anonymous",
        "subComponents": {},
        "config": {
          "allow-default-scopes": [
            "true"
          ]
        }
      },
      {
        "id": "10eb7fdd-9f5a-43a6-91d9-3a7221ace90c",
        "name": "Allowed Client Scopes",
        "providerId": "allowed-client-templates",
        "subType": "authenticated",
        "subComponents": {},
        "config": {
          "allow-default-scopes": [
            "true"
          ]
        }
      },
      {
        "id": "ac3dffd3-3f09-4e81-9644-dcddb380e26f",
        "name": "Full Scope Disabled",
        "providerId": "scope",
        "subType": "anonymous",
        "subComponents": {},
        "config": {}
      },
      {
        "id": "f6fac685-e8ef-48ec-bc36-282c8339594e",
        "name": "Trusted Hosts",
        "providerId": "trusted-hosts",
        "subType": "anonymous",
        "subComponents": {},
        "config": {
          "host-sending-registration-request-must-match": [
            "true"
          ],
          "client-uris-must-match": [
            "true"
          ]
        }
      },
      {
        "id": "5ba68c0e-4680-4b9d-8302-73a522548d2b",
        "name": "Allowed Protocol Mapper Types",
        "providerId": "allowed-protocol-mappers",
        "subType": "authenticated",
        "subComponents": {},
        "config": {
          "allowed-protocol-mapper-types": [
            "oidc-usermodel-property-mapper",
            "oidc-usermodel-attribute-mapper",
            "oidc-full-name-mapper",
            "saml-user-property-mapper",
            "saml-user-attribute-mapper",
            "oidc-address-mapper",
            "oidc-sha256-pairwise-sub-mapper",
            "saml-role-list-mapper"
          ]
        }
      }
    ],
    "org.keycloak.keys.KeyProvider": [
      {
        "id": "1e22e936-0cb2-4ac2-8363-efc78b868f0d",
        "name": "hmac-generated-hs512",
        "providerId": "hmac-generated",
        "subComponents": {},
        "config": {
          "priority": [
            "100"
          ],
          "algorithm": [
            "HS512"
          ]
        }
      },
      {
        "id": "4aa03f2d-3a4c-4af0-a769-a999720e7ebd",
        "name": "aes-generated",
        "providerId": "aes-generated",
        "subComponents": {},
        "config": {
          "priority": [
            "100"
          ]
        }
      },
      {
        "id": "cf6d7922-8bfb-4a54-869d-f753ce0302fa",
        "name": "rsa-enc-generated",
        "providerId": "rsa-enc-generated",
        "subComponents": {},
        "config": {
          "priority": [
            "100"
          ],
          "algorithm": [
            "RSA-OAEP"
          ]
        }
      },
      {
        "id": "b1679c23-b77c-4b64-952c-8dacab957a93",
        "name": "rsa-generated",
        "providerId": "rsa-generated",
        "subComponents": {},
        "config": {
          "priority": [
            "100"
          ]
        }
      }
    ]
  },
  "internationalizationEnabled": false,
  "authenticationFlows": [
    {
      "id": "f310dbb7-c736-46f1-9c94-0325b85a28d9",
      "alias": "Account verification options",
      "description": "Method with which to verity the existing account",
      "providerId": "basic-flow",
      "topLevel": false,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "idp-email-verification",
          "authenticatorFlow": false,
          "requirement": "ALTERNATIVE",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticatorFlow": true,
          "requirement": "ALTERNATIVE",
          "priority": 20,
          "autheticatorFlow": true,
          "flowAlias": "Verify Existing Account by Re-authentication",
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "e2b0b30e-fe3b-4e30-8633-4e5501067774",
      "alias": "Browser - Conditional 2FA",
      "description": "Flow to determine if any 2FA is required for the authentication",
      "providerId": "basic-flow",
      "topLevel": false,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "conditional-user-configured",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticatorConfig": "browser-conditional-credential",
          "authenticator": "conditional-credential",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 20,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "auth-otp-form",
          "authenticatorFlow": false,
          "requirement": "ALTERNATIVE",
          "priority": 30,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "webauthn-authenticator",
          "authenticatorFlow": false,
          "requirement": "DISABLED",
          "priority": 40,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "auth-recovery-authn-code-form",
          "authenticatorFlow": false,
          "requirement": "DISABLED",
          "priority": 50,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "47e73c9f-3161-446e-86f4-68bde1fc34a9",
      "alias": "Browser - Conditional Organization",
      "description": "Flow to determine if the organization identity-first login is to be used",
      "providerId": "basic-flow",
      "topLevel": false,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "conditional-user-configured",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "organization",
          "authenticatorFlow": false,
          "requirement": "ALTERNATIVE",
          "priority": 20,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "8c914e51-2c92-41f5-87d0-fe303a62ed75",
      "alias": "Direct Grant - Conditional OTP",
      "description": "Flow to determine if the OTP is required for the authentication",
      "providerId": "basic-flow",
      "topLevel": false,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "conditional-user-configured",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "direct-grant-validate-otp",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 20,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "fc79ca55-5f1c-486b-b846-3d538891abf3",
      "alias": "First Broker Login - Conditional Organization",
      "description": "Flow to determine if the authenticator that adds organization members is to be used",
      "providerId": "basic-flow",
      "topLevel": false,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "conditional-user-configured",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "idp-add-organization-member",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 20,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "c6f9a048-7dbe-4c3f-9eed-3ed5a6fb43df",
      "alias": "First broker login - Conditional 2FA",
      "description": "Flow to determine if any 2FA is required for the authentication",
      "providerId": "basic-flow",
      "topLevel": false,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "conditional-user-configured",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticatorConfig": "first-broker-login-conditional-credential",
          "authenticator": "conditional-credential",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 20,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "auth-otp-form",
          "authenticatorFlow": false,
          "requirement": "ALTERNATIVE",
          "priority": 30,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "webauthn-authenticator",
          "authenticatorFlow": false,
          "requirement": "DISABLED",
          "priority": 40,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "auth-recovery-authn-code-form",
          "authenticatorFlow": false,
          "requirement": "DISABLED",
          "priority": 50,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "387e7dd9-9642-45b9-93d7-c164808ecbe2",
      "alias": "Handle Existing Account",
      "description": "Handle what to do if there is existing account with same email/username like authenticated identity provider",
      "providerId": "basic-flow",
      "topLevel": false,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "idp-confirm-link",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticatorFlow": true,
          "requirement": "REQUIRED",
          "priority": 20,
          "autheticatorFlow": true,
          "flowAlias": "Account verification options",
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "0d0c1add-9d14-4a33-a66e-c9fb00427344",
      "alias": "Organization",
      "providerId": "basic-flow",
      "topLevel": false,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticatorFlow": true,
          "requirement": "CONDITIONAL",
          "priority": 10,
          "autheticatorFlow": true,
          "flowAlias": "Browser - Conditional Organization",
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "73e60798-7693-4801-92e5-3145e6b64ea8",
      "alias": "Reset - Conditional OTP",
      "description": "Flow to determine if the OTP should be reset or not. Set to REQUIRED to force.",
      "providerId": "basic-flow",
      "topLevel": false,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "conditional-user-configured",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "reset-otp",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 20,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "8cce7a30-dc40-4eb3-a811-cc05cb69ecd2",
      "alias": "User creation or linking",
      "description": "Flow for the existing/non-existing user alternatives",
      "providerId": "basic-flow",
      "topLevel": false,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticatorConfig": "create unique user config",
          "authenticator": "idp-create-user-if-unique",
          "authenticatorFlow": false,
          "requirement": "ALTERNATIVE",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticatorFlow": true,
          "requirement": "ALTERNATIVE",
          "priority": 20,
          "autheticatorFlow": true,
          "flowAlias": "Handle Existing Account",
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "3ec086f3-1f81-4351-a2b1-5c96e72da6f2",
      "alias": "Verify Existing Account by Re-authentication",
      "description": "Reauthentication of existing account",
      "providerId": "basic-flow",
      "topLevel": false,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "idp-username-password-form",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticatorFlow": true,
          "requirement": "CONDITIONAL",
          "priority": 20,
          "autheticatorFlow": true,
          "flowAlias": "First broker login - Conditional 2FA",
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "a2bc0e7c-8e06-42d5-aa69-6370891f29cd",
      "alias": "browser",
      "description": "Browser based authentication",
      "providerId": "basic-flow",
      "topLevel": true,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "auth-cookie",
          "authenticatorFlow": false,
          "requirement": "ALTERNATIVE",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "auth-spnego",
          "authenticatorFlow": false,
          "requirement": "DISABLED",
          "priority": 20,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "identity-provider-redirector",
          "authenticatorFlow": false,
          "requirement": "ALTERNATIVE",
          "priority": 25,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticatorFlow": true,
          "requirement": "ALTERNATIVE",
          "priority": 26,
          "autheticatorFlow": true,
          "flowAlias": "Organization",
          "userSetupAllowed": false
        },
        {
          "authenticatorFlow": true,
          "requirement": "ALTERNATIVE",
          "priority": 30,
          "autheticatorFlow": true,
          "flowAlias": "forms",
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "b080eb15-4058-4d5e-b2e9-852b411fd7bd",
      "alias": "clients",
      "description": "Base authentication for clients",
      "providerId": "client-flow",
      "topLevel": true,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "client-secret",
          "authenticatorFlow": false,
          "requirement": "ALTERNATIVE",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "client-jwt",
          "authenticatorFlow": false,
          "requirement": "ALTERNATIVE",
          "priority": 20,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "client-secret-jwt",
          "authenticatorFlow": false,
          "requirement": "ALTERNATIVE",
          "priority": 30,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "client-x509",
          "authenticatorFlow": false,
          "requirement": "ALTERNATIVE",
          "priority": 40,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "e16c047a-d1c3-4158-9cba-32de9f10561e",
      "alias": "direct grant",
      "description": "OpenID Connect Resource Owner Grant",
      "providerId": "basic-flow",
      "topLevel": true,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "direct-grant-validate-username",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "direct-grant-validate-password",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 20,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticatorFlow": true,
          "requirement": "CONDITIONAL",
          "priority": 30,
          "autheticatorFlow": true,
          "flowAlias": "Direct Grant - Conditional OTP",
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "041c26ca-b7ca-4c7a-a72d-2e2d45f92f67",
      "alias": "docker auth",
      "description": "Used by Docker clients to authenticate against the IDP",
      "providerId": "basic-flow",
      "topLevel": true,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "docker-http-basic-authenticator",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "dbdc2069-eeef-447e-a2ca-f71d4f621d61",
      "alias": "first broker login",
      "description": "Actions taken after first broker login with identity provider account, which is not yet linked to any Keycloak account",
      "providerId": "basic-flow",
      "topLevel": true,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticatorConfig": "review profile config",
          "authenticator": "idp-review-profile",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticatorFlow": true,
          "requirement": "REQUIRED",
          "priority": 20,
          "autheticatorFlow": true,
          "flowAlias": "User creation or linking",
          "userSetupAllowed": false
        },
        {
          "authenticatorFlow": true,
          "requirement": "CONDITIONAL",
          "priority": 60,
          "autheticatorFlow": true,
          "flowAlias": "First Broker Login - Conditional Organization",
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "a28b5241-b6bb-48b4-875d-69966467c40c",
      "alias": "forms",
      "description": "Username, password, otp and other auth forms.",
      "providerId": "basic-flow",
      "topLevel": false,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "auth-username-password-form",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticatorFlow": true,
          "requirement": "CONDITIONAL",
          "priority": 20,
          "autheticatorFlow": true,
          "flowAlias": "Browser - Conditional 2FA",
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "8a11509d-290c-4a1a-a7a3-125fbe1386b7",
      "alias": "registration",
      "description": "Registration flow",
      "providerId": "basic-flow",
      "topLevel": true,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "registration-page-form",
          "authenticatorFlow": true,
          "requirement": "REQUIRED",
          "priority": 10,
          "autheticatorFlow": true,
          "flowAlias": "registration form",
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "e296bb4f-8441-4dab-952a-68d6391c994b",
      "alias": "registration form",
      "description": "Registration form",
      "providerId": "form-flow",
      "topLevel": false,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "registration-user-creation",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 20,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "registration-password-action",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 50,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "registration-recaptcha-action",
          "authenticatorFlow": false,
          "requirement": "DISABLED",
          "priority": 60,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "registration-terms-and-conditions",
          "authenticatorFlow": false,
          "requirement": "DISABLED",
          "priority": 70,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "61ee016d-5af9-48aa-9555-c8825e13a43e",
      "alias": "reset credentials",
      "description": "Reset credentials for a user if they forgot their password or something",
      "providerId": "basic-flow",
      "topLevel": true,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "reset-credentials-choose-user",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "reset-credential-email",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 20,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticator": "reset-password",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 30,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        },
        {
          "authenticatorFlow": true,
          "requirement": "CONDITIONAL",
          "priority": 40,
          "autheticatorFlow": true,
          "flowAlias": "Reset - Conditional OTP",
          "userSetupAllowed": false
        }
      ]
    },
    {
      "id": "b206b82f-f473-4b64-9bb6-f938fe1028b3",
      "alias": "saml ecp",
      "description": "SAML ECP Profile Authentication Flow",
      "providerId": "basic-flow",
      "topLevel": true,
      "builtIn": true,
      "authenticationExecutions": [
        {
          "authenticator": "http-basic-authenticator",
          "authenticatorFlow": false,
          "requirement": "REQUIRED",
          "priority": 10,
          "autheticatorFlow": false,
          "userSetupAllowed": false
        }
      ]
    }
  ],
  "authenticatorConfig": [
    {
      "id": "9cf7226a-0df3-4aae-bff8-8a7a6fbf0a6c",
      "alias": "browser-conditional-credential",
      "config": {
        "credentials": "webauthn-passwordless"
      }
    },
    {
      "id": "04bc1bda-f153-4c7d-968e-58833e7fa51a",
      "alias": "create unique user config",
      "config": {
        "require.password.update.after.registration": "false"
      }
    },
    {
      "id": "dc788088-6f42-4d9e-9978-61d570cf6471",
      "alias": "first-broker-login-conditional-credential",
      "config": {
        "credentials": "webauthn-passwordless"
      }
    },
    {
      "id": "73c87e9c-4916-4b05-8d9d-a3f4c3371d99",
      "alias": "review profile config",
      "config": {
        "update.profile.on.first.login": "missing"
      }
    }
  ],
  "requiredActions": [
    {
      "alias": "CONFIGURE_TOTP",
      "name": "Configure OTP",
      "providerId": "CONFIGURE_TOTP",
      "enabled": true,
      "defaultAction": false,
      "priority": 10,
      "config": {}
    },
    {
      "alias": "TERMS_AND_CONDITIONS",
      "name": "Terms and Conditions",
      "providerId": "TERMS_AND_CONDITIONS",
      "enabled": false,
      "defaultAction": false,
      "priority": 20,
      "config": {}
    },
    {
      "alias": "UPDATE_PASSWORD",
      "name": "Update Password",
      "providerId": "UPDATE_PASSWORD",
      "enabled": true,
      "defaultAction": false,
      "priority": 30,
      "config": {}
    },
    {
      "alias": "UPDATE_PROFILE",
      "name": "Update Profile",
      "providerId": "UPDATE_PROFILE",
      "enabled": true,
      "defaultAction": false,
      "priority": 40,
      "config": {}
    },
    {
      "alias": "VERIFY_EMAIL",
      "name": "Verify Email",
      "providerId": "VERIFY_EMAIL",
      "enabled": true,
      "defaultAction": false,
      "priority": 50,
      "config": {}
    },
    {
      "alias": "delete_account",
      "name": "Delete Account",
      "providerId": "delete_account",
      "enabled": false,
      "defaultAction": false,
      "priority": 60,
      "config": {}
    },
    {
      "alias": "UPDATE_EMAIL",
      "name": "Update Email",
      "providerId": "UPDATE_EMAIL",
      "enabled": false,
      "defaultAction": false,
      "priority": 70,
      "config": {}
    },
    {
      "alias": "webauthn-register",
      "name": "Webauthn Register",
      "providerId": "webauthn-register",
      "enabled": true,
      "defaultAction": false,
      "priority": 80,
      "config": {}
    },
    {
      "alias": "webauthn-register-passwordless",
      "name": "Webauthn Register Passwordless",
      "providerId": "webauthn-register-passwordless",
      "enabled": true,
      "defaultAction": false,
      "priority": 90,
      "config": {}
    },
    {
      "alias": "VERIFY_PROFILE",
      "name": "Verify Profile",
      "providerId": "VERIFY_PROFILE",
      "enabled": true,
      "defaultAction": false,
      "priority": 100,
      "config": {}
    },
    {
      "alias": "delete_credential",
      "name": "Delete Credential",
      "providerId": "delete_credential",
      "enabled": true,
      "defaultAction": false,
      "priority": 110,
      "config": {}
    },
    {
      "alias": "idp_link",
      "name": "Linking Identity Provider",
      "providerId": "idp_link",
      "enabled": true,
      "defaultAction": false,
      "priority": 120,
      "config": {}
    },
    {
      "alias": "CONFIGURE_RECOVERY_AUTHN_CODES",
      "name": "Recovery Authentication Codes",
      "providerId": "CONFIGURE_RECOVERY_AUTHN_CODES",
      "enabled": true,
      "defaultAction": false,
      "priority": 130,
      "config": {}
    },
    {
      "alias": "update_user_locale",
      "name": "Update User Locale",
      "providerId": "update_user_locale",
      "enabled": true,
      "defaultAction": false,
      "priority": 1000,
      "config": {}
    }
  ],
  "browserFlow": "browser",
  "registrationFlow": "registration",
  "directGrantFlow": "direct grant",
  "resetCredentialsFlow": "reset credentials",
  "clientAuthenticationFlow": "clients",
  "dockerAuthenticationFlow": "docker auth",
  "firstBrokerLoginFlow": "first broker login",
  "attributes": {
    "cibaBackchannelTokenDeliveryMode": "poll",
    "cibaExpiresIn": "120",
    "cibaAuthRequestedUserHint": "login_hint",
    "oauth2DeviceCodeLifespan": "600",
    "oauth2DevicePollingInterval": "5",
    "parRequestUriLifespan": "60",
    "cibaInterval": "5",
    "realmReusableOtpCode": "false"
  },
  "keycloakVersion": "26.4.5",
  "userManagedAccessAllowed": false,
  "organizationsEnabled": false,
  "verifiableCredentialsEnabled": false,
  "adminPermissionsEnabled": false,
  "clientProfiles": {
    "profiles": []
  },
  "clientPolicies": {
    "policies": []
  }
}`

docker compose
`volumes:
  postgres_data:
    driver: local
services:
  pgadmin_service:
    image: dpage/pgadmin4
    container_name: pgadmin
    environment:
      PGADMIN_DEFAULT_EMAIL: admin@development.com
      PGADMIN_DEFAULT_PASSWORD: password
    ports:
      - "15432:80"
    volumes:
      - postgres_data:/var/lib/pgadmin
  postgres_service:
    image: postgres:latest
    container_name: postgres
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: password
    volumes:
      - postgres_data:/var/lib/postgresql/data
    ports:
      - "5432:5432"
    healthcheck:
      test: [ "CMD-SHELL", "pg_isready -U postgres" ]
      interval: 10s
      timeout: 5s
      retries: 5
  keycloak_service:
    image: quay.io/keycloak/keycloak:latest
    container_name: keycloak
    command: [ "start-dev", "--http-port", "8080", "--https-port", "7443" ]
    environment:
      KC_DB: postgres
      KC_DB_URL_HOST: postgres
      KC_DB_USERNAME: postgres
      KC_DB_PASSWORD: password
      KEYCLOAK_ADMIN: admin
      KEYCLOAK_ADMIN_PASSWORD: password
    ports:
      - "8080:8080"
    depends_on:
      postgres_service:
        condition: service_healthy
`